// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.ide.util.treeView;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.testFramework.PlatformTestUtil;
import com.intellij.ui.SimpleTextAttributes;
import com.intellij.ui.tree.TreeTestUtil;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.WaitFor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.*;

abstract class AbstractTreeBuilderTest extends BaseTreeTestCase<BaseTreeTestCase.NodeElement> {
  protected MyStructure myStructure;

  Node myRoot;
  DefaultTreeModel myTreeModel;
  Node myCom;
  Node myOpenApi;
  Node myIde;
  Node myRunner;
  Node myRcp;


  boolean myEnsureSelection = false;

  AbstractTreeBuilderTest.Node myFabrique;


  Map<NodeElement, ElementEntry> myElementUpdate = new TreeMap<>();
  ElementUpdateHook myElementUpdateHook;

  Map<String, Integer> mySortedParent = new TreeMap<>();

  NodeDescriptor.NodeComparator.Delegate<NodeDescriptor<?>> myComparator;
  Node myIntellij;

  protected final Set<NodeElement> myChanges = new HashSet<>();

  protected AbstractTreeBuilderTest(boolean passThrough) {
    super(passThrough);
  }

  protected AbstractTreeBuilderTest(boolean yieldingUiBuild, boolean bgStructureBuilding) {
    super(yieldingUiBuild, bgStructureBuilding);
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    myComparator = new NodeDescriptor.NodeComparator.Delegate<>(new NodeDescriptor.NodeComparator<>() {
      @Override
      public int compare(NodeDescriptor<?> o1, NodeDescriptor<?> o2) {
        return AlphaComparator.INSTANCE.compare(o1, o2);
      }
    });

    mySortedParent.clear();

    myTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode(null));
    myTreeModel.addTreeModelListener(new TreeModelListener() {
      @Override
      public void treeNodesChanged(TreeModelEvent e) {
        assertEdt();
      }

      @Override
      public void treeNodesInserted(TreeModelEvent e) {
        assertEdt();
      }

      @Override
      public void treeNodesRemoved(TreeModelEvent e) {
        assertEdt();
      }

      @Override
      public void treeStructureChanged(TreeModelEvent e) {
        assertEdt();
      }
    });


    myTree = new Tree(myTreeModel);
    TreeTestUtil.assertTreeUI(myTree);
    myStructure = new MyStructure();
    myRoot = new Node(null, "/");

    initBuilder(new MyBuilder());

    myTree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
      @Override
      public void valueChanged(TreeSelectionEvent e) {
        assertEdt();
      }
    });

    myTree.addTreeExpansionListener(new TreeExpansionListener() {
      @Override
      public void treeExpanded(TreeExpansionEvent event) {
        assertEdt();
      }

      @Override
      public void treeCollapsed(TreeExpansionEvent event) {
        assertEdt();
      }
    });
  }

  @Override
  protected void tearDown() throws Exception {
    try {
      myElementUpdate.clear();
      myElementUpdateHook = null;
      myStructure.setReValidator(null);
    }
    finally {
      super.tearDown();
    }
  }

  @Nullable
  Node removeFromParentButKeepRef(NodeElement child) {
    NodeElement parent = (NodeElement)myStructure.getParentElement(child);
    AbstractTreeBuilderTest.Node node = myStructure.getNodeFor(parent).remove(child, false);
    assertEquals(parent, myStructure.getParentElement(child));
    assertFalse(Arrays.asList(myStructure._getChildElements(parent, false)).contains(child));

    return node;
  }

  void assertSorted(String expected) {
    Iterator<String> keys = mySortedParent.keySet().iterator();
    StringBuilder result = new StringBuilder();
    while (keys.hasNext()) {
      String each = keys.next();
      result.append(each);
      int count = mySortedParent.get(each);
      if (count > 1) {
        result.append(" (").append(count).append(")");
      }

      if (keys.hasNext()) {
        result.append("\n");
      }
    }

    assertEquals(expected, result.toString());
    mySortedParent.clear();
  }

  private void addEntry(String value) {
    if (mySortedParent.containsKey(value)) {
      mySortedParent.put(value, mySortedParent.get(value) + 1);
    } else {
      mySortedParent.put(value, 0);
    }
  }

  void assertUpdates(String expected) {
    List<Object> entries = Arrays.asList(myElementUpdate.values().toArray());
    assertEquals(expected + "\n", PlatformTestUtil.print(entries) + "\n");
    myElementUpdate.clear();
  }

  void buildStructure(final Node root) throws Exception {
    buildStructure(root, true);
  }

  void buildStructure(final Node root, final boolean activate) throws Exception {
    doAndWaitForBuilder(() -> {
      myCom = root.addChild("com");
      myIntellij = myCom.addChild("intellij");
      myOpenApi = myIntellij.addChild("openapi");
      myFabrique = root.addChild("jetbrains").addChild("fabrique");
      myIde = myFabrique.addChild("ide");
      myRunner = root.addChild("xUnit").addChild("runner");
      myRcp = root.addChild("org").addChild("eclipse").addChild("rcp");

      if (activate) {
        getBuilder().getUi().activate(true);
      }
    });
  }

  protected void activate() throws Exception {
    doAndWaitForBuilder(() -> getBuilder().getUi().activate(true));
  }


  void hideTree() throws Exception {
    assertFalse(getMyBuilder().myWasCleanedUp);

    invokeLaterIfNeeded(() -> getBuilder().getUi().deactivate());

    final WaitFor waitFor = new WaitFor() {
      @Override
      protected boolean condition() {
        return getMyBuilder().myWasCleanedUp || myCancelRequest != null;
      }
    };

    if (myCancelRequest != null) {
      throw new Exception(myCancelRequest);
    }

    waitFor.assertCompleted("Tree cleanup was not performed. isCancelledReadyState=" + getBuilder().getUi().isCancelledReady());

    assertTrue(getMyBuilder().myWasCleanedUp);
  }

  void buildNode(String elementText, boolean select) throws Exception {
    buildNode(new NodeElement(elementText), select);
  }

  void buildNode(Node node, boolean select) throws Exception {
    buildNode(node.myElement, select);
  }

  void buildNode(final NodeElement element, final boolean select) throws Exception {
    buildNode(element, select, true);
  }


  void buildNode(final NodeElement element, final boolean select, final boolean addToSelection) throws Exception {
    final boolean[] done = new boolean[] {false};

    doAndWaitForBuilder(() -> {
      if (select) {
        getBuilder().select(element, () -> done[0] = true, addToSelection);
      } else {
        getBuilder().expand(element, () -> done[0] = true);
      }
    }, o -> done[0]);

    assertNotNull(findNode(element, select));
  }


  @Nullable
  DefaultMutableTreeNode findNode(String elementText, boolean shouldBeSelected) {
    return findNode(new NodeElement(elementText), shouldBeSelected);
  }

  @Nullable
  DefaultMutableTreeNode findNode(NodeElement element, boolean shouldBeSelected) {
    return findNode((DefaultMutableTreeNode)myTree.getModel().getRoot(), element, shouldBeSelected);
  }

  private @Nullable DefaultMutableTreeNode findNode(DefaultMutableTreeNode treeNode, NodeElement toFind, boolean shouldBeSelected) {
    final Object object = treeNode.getUserObject();
    assertNotNull(object);
    if (!(object instanceof NodeDescriptor)) return null;
    final NodeElement element = (NodeElement)((NodeDescriptor<?>)object).getElement();
    if (toFind.equals(element)) return treeNode;

    for (int i = 0; i < treeNode.getChildCount(); i++) {
      final DefaultMutableTreeNode result = findNode((DefaultMutableTreeNode)treeNode.getChildAt(i), toFind, shouldBeSelected);
      if (result != null) {
        if (shouldBeSelected) {
          final TreePath path = new TreePath(result.getPath());
          assertTrue("Path should be selected: " + path, myTree.isPathSelected(path));
        }
        return result;
      }
    }

    return null;
  }

  class Node  {

    final NodeElement myElement;
    final ArrayList<Node> myChildElements = new ArrayList<>();

    Node(Node parent, String textName) {
      this(parent, new NodeElement(textName));
    }

    Node(Node parent, NodeElement name) {
      myElement = name;
      setParent(parent);
    }

    private void setParent(Node parent) {
      myStructure.register(parent != null ? parent.myElement : null, this);
    }

    public NodeElement getElement() {
      return myElement;
    }

    public Node addChild(Node node) {
      myChildElements.add(node);
      node.setParent(this);
      return node;
    }

    public Node addChild(String name) {
      final Node node = new Node(this, name);
      myChildElements.add(node);
      return node;
    }

    public Node addChild(NodeElement element) {
      final Node node = new Node(this, element);
      myChildElements.add(node);
      return node;
    }

    @Override
    public String toString() {
      return myElement.toString();
    }

    public void removeAll() {
      myChildElements.clear();
    }

    public @Nullable Node getChildNode(String name) {
      for (Node each : myChildElements) {
        if (name.equals(each.myElement.myName)) return each;
      }

      return null;
    }

    public Object[] getChildElements() {
      Object[] elements = new Object[myChildElements.size()];
      for (int i = 0; i < myChildElements.size(); i++) {
        elements[i] = myChildElements.get(i).myElement;
      }
      return elements;
    }

    public void delete() {
      final NodeElement parent = (NodeElement)myStructure.getParentElement(myElement);
      assertNotNull(myElement.toString(), parent);

      myStructure.getNodeFor(parent).remove(myElement, true);
    }

    private @Nullable Node remove(final NodeElement name, boolean removeRefToParent) {
      final Iterator<Node> kids = myChildElements.iterator();
      Node removed = null;
      while (kids.hasNext()) {
        Node each = kids.next();
        if (name.equals(each.myElement)) {
          kids.remove();
          removed = each;
          break;
        }
      }

      if (removeRefToParent) {
        myStructure.myChild2Parent.remove(name);
      }

      return removed;
    }
  }

  class MyStructure extends BaseStructure {
    private final Map<NodeElement, NodeElement> myChild2Parent = new HashMap<>();
    private final Map<NodeElement, Node> myElement2Node = new HashMap<>();
    private final Set<NodeElement> myLeaves = new HashSet<>();
    private ReValidator myReValidator;

    @Override
    public @NotNull Object getRootElement() {
      return myRoot.myElement;
    }

    public void reInitRoot(Node root) {
      myRoot = root;
      myElement2Node.clear();
      myLeaves.clear();
      myElement2Node.put(root.myElement, root);
    }

    @Override
    public Object[] doGetChildElements(Object element) {

      onElementAction("getChildren", (NodeElement)element);

      final AbstractTreeBuilderTest.Node node = myElement2Node.get((NodeElement)element);
      return node.getChildElements();
    }

    @Override
    public Object getParentElement(final @NotNull Object element) {
      NodeElement nodeElement = (NodeElement)element;
      return nodeElement.getForcedParent() != null ? nodeElement.getForcedParent() : myChild2Parent.get(nodeElement);
    }

    @Override
    public boolean isAlwaysLeaf(@NotNull Object element) {
      //noinspection SuspiciousMethodCalls
      return myLeaves.contains(element);
    }

    public void addLeaf(NodeElement element) {
      myLeaves.add(element);
    }

    public void removeLeaf(NodeElement element) {
      myLeaves.remove(element);
    }

    @Override
    public @NotNull NodeDescriptor doCreateDescriptor(final Object element, final NodeDescriptor parentDescriptor) {
      return new PresentableNodeDescriptor(null, parentDescriptor) {
        @Override
        protected void update(@NotNull PresentationData presentation) {
          onElementAction("update", (NodeElement)element);
          presentation.clear();
          presentation.addText(new ColoredFragment(getElement().toString(), SimpleTextAttributes.REGULAR_ATTRIBUTES));

          if (myChanges.contains(element)) {
            myChanges.remove(element);
            presentation.setChanged(true);
          }
        }

        @Override
        public @Nullable PresentableNodeDescriptor getChildToHighlightAt(int index) {
          return null;
        }

        @Override
        public Object getElement() {
          return element;
        }

        @Override
        public String toString() {
          List<ColoredFragment> coloredText = getPresentation().getColoredText();
          StringBuilder result = new StringBuilder();
          for (ColoredFragment each : coloredText) {
            result.append(each.getText());
          }
          return result.toString();
        }
      };
    }

    public void register(final NodeElement parent, final Node child) {
      myChild2Parent.put(child.myElement, parent);
      myElement2Node.put(child.myElement, child);
    }

    public void clear() {
      myChild2Parent.clear();
      myElement2Node.clear();
      myElement2Node.put(myRoot.myElement, myRoot);
    }

    public Node getNodeFor(NodeElement element) {
      return myElement2Node.get(element);
    }

    @Override
    public @NotNull Object revalidateElement(@NotNull Object element) {
      return myReValidator == null ? super.revalidateElement(element) : myReValidator.revalidate((NodeElement)element);
    }

    public void setReValidator(@Nullable ReValidator reValidator) {
      myReValidator = reValidator;
    }
  }

  interface ReValidator {
    @Nullable Object revalidate(@NotNull NodeElement element);
  }

  final class MyBuilder extends BaseTreeBuilder {
    MyBuilder() {
      super(AbstractTreeBuilderTest.this.myTree, AbstractTreeBuilderTest.this.myTreeModel, AbstractTreeBuilderTest.this.myStructure, myComparator, false);

      initRootNode();
    }

    @Override
    protected void sortChildren(Comparator<? super TreeNode> nodeComparator, DefaultMutableTreeNode node, List<? extends TreeNode> children) {
      super.sortChildren(nodeComparator, node, children);
      addEntry(node.toString());
    }

    @Override
    public boolean isToEnsureSelectionOnFocusGained() {
      return myEnsureSelection;
    }
  }

  private void onElementAction(String action, NodeElement element) {
    myElementUpdate.computeIfAbsent(element, k -> new ElementEntry(element)).onElementAction(action);

    if (myElementUpdateHook != null) {
      myElementUpdateHook.onElementAction(action, element);
    }
  }

  interface ElementUpdateHook {
    void onElementAction(String action, Object element);
  }

  private final class ElementEntry {
    NodeElement myElement;

    int myUpdateCount;
    int myGetChildrenCount;

    private ElementEntry(NodeElement element) {
      myElement = element;
    }

    void onElementAction(String action) {
      try {
        if ("update".equals(action)) {
          myUpdateCount++;
        } else if ("getChildren".equals(action)) {
          assertTrue("getChildren() is called before update(), node=" + myElement, myUpdateCount > 0);
          myGetChildrenCount++;
        }
      }
      catch (Throwable e) {
        myCancelRequest = e;
      }
    }

    @Override
    public String toString() {
      return (myElement + ": " + asString(myUpdateCount, "update") + " " + asString(myGetChildrenCount, "getChildren")).trim();
    }

    private String asString(int count, String text) {
      if (count == 0) return "";
      return count > 1 ? text + " (" + count + ")" : text;
    }
  }



  MyBuilder getMyBuilder() {
    return (MyBuilder)getBuilder();
  }

  interface TreeAction {
    void run(Runnable onDone);
  }

  TreePath getPath(String s) {
    return new TreePath(Objects.requireNonNull(findNode(s, false)).getPath());
  }
}

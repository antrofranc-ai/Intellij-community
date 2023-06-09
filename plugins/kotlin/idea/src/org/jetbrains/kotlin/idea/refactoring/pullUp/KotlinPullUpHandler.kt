// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.refactoring.pullUp

import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiNamedElement
import com.intellij.refactoring.HelpID
import com.intellij.refactoring.RefactoringBundle
import com.intellij.refactoring.util.CommonRefactoringUtil
import org.jetbrains.annotations.NonNls
import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.idea.caches.resolve.unsafeResolveToDescriptor
import org.jetbrains.kotlin.idea.codeInsight.DescriptorToSourceUtilsIde
import org.jetbrains.kotlin.idea.refactoring.AbstractPullPushMembersHandler
import org.jetbrains.kotlin.idea.refactoring.canRefactor
import org.jetbrains.kotlin.idea.refactoring.memberInfo.KotlinMemberInfo
import org.jetbrains.kotlin.idea.refactoring.memberInfo.KotlinMemberInfoStorage
import org.jetbrains.kotlin.idea.refactoring.memberInfo.qualifiedClassNameForRendering
import org.jetbrains.kotlin.idea.util.application.isUnitTestMode
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.psi.KtNamedDeclaration
import org.jetbrains.kotlin.psi.psiUtil.getStrictParentOfType
import org.jetbrains.kotlin.types.typeUtil.supertypes

class KotlinPullUpHandler : AbstractPullPushMembersHandler(
    refactoringName = PULL_MEMBERS_UP,
    helpId = HelpID.MEMBERS_PULL_UP,
    wrongPositionMessage = RefactoringBundle.message("the.caret.should.be.positioned.inside.a.class.to.pull.members.from")
) {
    companion object {
        @NonNls
        const val PULL_UP_TEST_HELPER_KEY = "PULL_UP_TEST_HELPER_KEY"
    }

    interface TestHelper {
        fun adjustMembers(members: List<KotlinMemberInfo>): List<KotlinMemberInfo>
        fun chooseSuperClass(superClasses: List<PsiNamedElement>): PsiNamedElement
    }

    private fun reportNoSuperClasses(project: Project, editor: Editor?, classOrObject: KtClassOrObject) {
        val message = RefactoringBundle.getCannotRefactorMessage(
            RefactoringBundle.message(
                "class.does.not.have.base.classes.interfaces.in.current.project",
                classOrObject.qualifiedClassNameForRendering()
            )
        )
        CommonRefactoringUtil.showErrorHint(project, editor, message, PULL_MEMBERS_UP, HelpID.MEMBERS_PULL_UP)
    }

    override fun invoke(
        project: Project,
        editor: Editor?,
        classOrObject: KtClassOrObject?,
        member: KtNamedDeclaration?,
        dataContext: DataContext?
    ) {
        if (classOrObject == null) {
            reportWrongContext(project, editor)
            return
        }

        val classDescriptor = classOrObject.unsafeResolveToDescriptor() as ClassDescriptor
        val superClasses = classDescriptor.defaultType
            .supertypes()
            .mapNotNull {
                val descriptor = it.constructor.declarationDescriptor
                val declaration = descriptor?.let { classifierDescriptor ->
                    DescriptorToSourceUtilsIde.getAnyDeclaration(project, classifierDescriptor)
                }
                if ((declaration is KtClass || declaration is PsiClass)
                    && declaration.canRefactor()
                ) declaration as PsiNamedElement else null
            }
            .sortedBy { it.qualifiedClassNameForRendering() }

        if (superClasses.isEmpty()) {
            val containingClass = classOrObject.getStrictParentOfType<KtClassOrObject>()
            if (containingClass != null) {
                invoke(project, editor, containingClass, classOrObject, dataContext)
            } else {
                reportNoSuperClasses(project, editor, classOrObject)
            }
            return
        }

        val memberInfoStorage = KotlinMemberInfoStorage(classOrObject)
        val members = memberInfoStorage.getClassMemberInfos(classOrObject)

        if (isUnitTestMode()) {
            val helper = dataContext?.getData(PULL_UP_TEST_HELPER_KEY) as TestHelper
            val selectedMembers = helper.adjustMembers(members)
            val targetClass = helper.chooseSuperClass(superClasses)
            checkConflicts(project, classOrObject, targetClass, selectedMembers) {
                KotlinPullUpDialog.createProcessor(classOrObject, targetClass, selectedMembers).run()
            }
        } else {
            val manager = classOrObject.manager
            members.filter { manager.areElementsEquivalent(it.member, member) }.forEach { it.isChecked = true }

            KotlinPullUpDialog(project, classOrObject, superClasses, memberInfoStorage).show()
        }
    }
}

val PULL_MEMBERS_UP: String get() = RefactoringBundle.message("pull.members.up.title")
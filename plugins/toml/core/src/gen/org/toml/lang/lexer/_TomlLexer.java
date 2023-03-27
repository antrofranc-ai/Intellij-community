// Generated by JFlex 1.9.1 http://jflex.de/  (tweaked for IntelliJ platform)
// source: TomlLexer.flex

package org.toml.lang.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static org.toml.lang.psi.TomlElementTypes.*;


public class _TomlLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\1\1\2\22\0\1\1"+
    "\1\0\1\3\1\4\3\0\1\5\3\0\1\6\1\7"+
    "\1\10\1\11\1\0\1\12\1\13\6\14\2\15\1\16"+
    "\2\0\1\17\3\0\4\20\1\21\1\20\15\22\1\23"+
    "\5\22\1\24\1\25\1\26\1\27\1\0\1\30\1\0"+
    "\1\31\1\32\2\20\1\33\1\34\2\22\1\35\2\22"+
    "\1\36\1\22\1\37\1\40\2\22\1\41\1\42\1\43"+
    "\1\44\2\22\1\45\1\22\1\24\1\46\1\0\1\47"+
    "\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\2\11\1\12\1\7\1\13\1\14\4\7"+
    "\1\15\1\16\3\3\3\5\2\17\2\0\2\11\1\0"+
    "\1\11\4\7\1\11\5\7\1\3\1\20\1\5\1\21"+
    "\4\0\1\11\1\17\1\11\2\0\1\7\4\17\1\11"+
    "\1\17\1\7\1\17\1\7\1\0\1\20\1\0\1\21"+
    "\2\17\1\11\1\0\1\11\1\22\1\0\1\20\1\0"+
    "\1\21\1\7\1\0\1\20\1\0\1\21\1\0\1\7"+
    "\1\0\1\20\1\21\1\7\1\0\1\7\1\23\1\7"+
    "\2\0\1\23\1\24\1\0\1\23\2\7\1\24\1\0"+
    "\2\7\1\0\2\7\1\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\170\0\240\0\310\0\360\0\50"+
    "\0\u0118\0\50\0\u0140\0\u0168\0\50\0\u0190\0\50\0\50"+
    "\0\u01b8\0\u01e0\0\u0208\0\u0230\0\50\0\50\0\u0258\0\u0280"+
    "\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\u0348\0\u0370\0\u0398\0\u03c0"+
    "\0\u03e8\0\u0410\0\u0438\0\u0460\0\u0488\0\u04b0\0\u04d8\0\u0500"+
    "\0\u0528\0\u0550\0\u0578\0\u05a0\0\u05c8\0\u05f0\0\50\0\u0618"+
    "\0\50\0\u0640\0\u0668\0\u0690\0\u06b8\0\u06e0\0\u0708\0\u0730"+
    "\0\u0758\0\u0780\0\u07a8\0\u07d0\0\u07f8\0\u0820\0\u0848\0\u0870"+
    "\0\u0898\0\u08c0\0\u08e8\0\u0190\0\u0910\0\u0938\0\u0960\0\u0988"+
    "\0\u09b0\0\u09d8\0\50\0\u0a00\0\u0a28\0\u0a50\0\u0190\0\u0a78"+
    "\0\u0aa0\0\u0ac8\0\u0af0\0\u0b18\0\u0b40\0\50\0\u0b68\0\50"+
    "\0\u0b90\0\u0bb8\0\u0be0\0\u0a78\0\u0ac8\0\u0c08\0\u0c30\0\u0c58"+
    "\0\u0c80\0\u0ca8\0\u0cd0\0\u0cf8\0\50\0\u0d20\0\u0d48\0\u0d70"+
    "\0\u0d98\0\u0dc0\0\u0190\0\u0de8\0\u0e10\0\u0e38\0\u0e60\0\u0e88"+
    "\0\u0eb0\0\u0ed8";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\3\14\1\2\1\15\5\16\1\17\1\2"+
    "\1\20\4\16\1\21\1\22\1\16\1\23\3\16\1\24"+
    "\2\16\1\25\1\26\51\0\2\3\45\0\2\27\1\0"+
    "\1\30\22\27\1\31\21\27\2\5\1\0\45\5\2\32"+
    "\1\0\2\32\1\33\20\32\1\34\21\32\12\0\1\35"+
    "\3\36\17\0\1\37\1\0\1\40\20\0\1\16\1\0"+
    "\1\41\3\42\2\0\5\16\3\0\5\16\1\22\1\16"+
    "\1\23\6\16\12\0\1\16\1\43\4\44\2\0\1\16"+
    "\1\45\3\16\3\0\2\16\1\46\1\45\4\16\1\47"+
    "\4\16\1\50\12\0\1\16\1\43\4\51\2\0\1\16"+
    "\1\45\3\16\3\0\1\52\2\16\1\45\12\16\12\0"+
    "\1\16\1\0\4\16\2\0\5\16\3\0\16\16\12\0"+
    "\1\16\1\0\4\16\2\0\5\16\3\0\1\16\1\53"+
    "\14\16\12\0\1\16\1\0\4\16\2\0\5\16\3\0"+
    "\7\16\1\54\6\16\12\0\1\16\1\0\4\16\2\0"+
    "\5\16\3\0\1\16\1\55\14\16\12\0\1\16\1\0"+
    "\4\16\2\0\5\16\3\0\11\16\1\56\4\16\2\0"+
    "\2\27\1\0\1\57\22\27\1\31\21\27\3\0\1\60"+
    "\44\0\26\27\1\31\21\27\2\32\1\0\2\32\1\61"+
    "\20\32\1\34\21\32\5\0\1\62\42\0\26\32\1\34"+
    "\21\32\11\0\1\43\7\0\1\63\11\0\1\63\25\0"+
    "\1\43\4\36\3\0\1\63\6\0\1\64\2\0\1\63"+
    "\53\0\1\65\41\0\1\66\26\0\1\16\1\43\4\67"+
    "\2\0\1\16\1\45\3\16\3\0\3\16\1\45\12\16"+
    "\12\0\1\16\1\43\4\42\2\0\1\16\1\45\3\16"+
    "\3\0\1\52\2\16\1\45\12\16\14\0\4\70\42\0"+
    "\1\16\1\0\4\71\1\72\1\0\5\16\3\0\16\16"+
    "\10\0\1\73\1\0\1\74\1\0\4\75\2\0\5\16"+
    "\3\0\16\16\12\0\1\16\1\0\2\76\2\16\2\0"+
    "\5\16\3\0\16\16\12\0\1\16\1\0\3\77\1\16"+
    "\2\0\5\16\3\0\16\16\12\0\1\16\1\0\4\100"+
    "\2\0\2\100\3\16\3\0\1\16\4\100\11\16\12\0"+
    "\1\16\1\43\4\101\1\72\1\0\1\16\1\45\3\16"+
    "\3\0\1\52\2\16\1\45\12\16\12\0\1\16\1\0"+
    "\4\102\2\0\5\16\3\0\16\16\12\0\1\16\1\0"+
    "\4\16\2\0\5\16\3\0\6\16\1\103\7\16\12\0"+
    "\1\16\1\0\4\16\2\0\5\16\3\0\4\16\1\104"+
    "\11\16\12\0\1\16\1\0\4\16\2\0\5\16\3\0"+
    "\7\16\1\104\6\16\12\0\1\16\1\0\4\16\2\0"+
    "\5\16\3\0\14\16\1\105\1\16\2\0\3\60\1\106"+
    "\22\60\1\107\21\60\5\62\1\110\20\62\1\111\21\62"+
    "\6\0\1\73\1\0\1\73\1\0\4\112\44\0\4\36"+
    "\66\0\1\113\52\0\1\113\20\0\1\16\1\0\4\67"+
    "\2\0\5\16\3\0\16\16\14\0\4\70\3\0\1\63"+
    "\6\0\1\43\2\0\1\63\24\0\1\16\1\0\4\114"+
    "\2\0\5\16\3\0\16\16\14\0\4\115\44\0\4\112"+
    "\42\0\1\16\1\0\4\75\2\0\5\16\3\0\16\16"+
    "\12\0\1\16\1\0\4\75\2\0\5\16\3\0\1\74"+
    "\15\16\12\0\1\16\1\0\2\76\2\16\2\0\5\16"+
    "\3\0\1\46\15\16\12\0\1\16\1\0\3\77\1\16"+
    "\2\0\5\16\3\0\1\47\15\16\12\0\1\16\1\0"+
    "\4\100\2\0\2\100\3\16\3\0\1\50\4\100\11\16"+
    "\12\0\1\16\1\43\4\116\2\0\1\16\1\45\3\16"+
    "\3\0\1\52\2\16\1\45\12\16\12\0\1\16\1\43"+
    "\4\102\2\0\1\16\1\45\3\16\3\0\1\52\2\16"+
    "\1\45\12\16\12\0\1\16\1\0\4\16\2\0\5\16"+
    "\3\0\12\16\1\105\3\16\12\0\1\16\1\0\4\16"+
    "\2\0\5\16\3\0\3\16\1\117\12\16\2\0\3\60"+
    "\1\120\47\60\1\121\22\60\1\107\21\60\5\62\1\122"+
    "\47\62\1\123\20\62\1\111\21\62\12\0\4\112\12\0"+
    "\1\73\27\0\1\124\1\0\4\67\2\0\5\16\3\0"+
    "\16\16\14\0\4\125\42\0\1\124\1\43\4\42\2\0"+
    "\1\16\1\45\3\16\3\0\1\52\2\16\1\45\12\16"+
    "\2\0\3\60\1\126\47\60\1\127\22\60\1\107\21\60"+
    "\5\62\1\130\47\62\1\131\20\62\1\111\21\62\10\0"+
    "\1\16\1\0\4\132\2\0\5\16\3\0\16\16\20\0"+
    "\1\133\31\0\3\60\1\134\44\60\5\62\1\135\42\62"+
    "\10\0\1\16\1\0\4\136\2\0\5\16\3\0\16\16"+
    "\14\0\4\137\42\0\1\140\1\0\4\16\2\0\5\16"+
    "\3\0\16\16\14\0\4\141\42\0\1\16\1\0\4\142"+
    "\2\0\5\16\3\0\16\16\10\0\1\143\1\0\1\143"+
    "\1\144\12\0\1\145\33\0\1\16\1\0\4\146\2\0"+
    "\5\16\3\0\16\16\14\0\4\147\44\0\4\150\40\0"+
    "\1\143\1\0\1\151\1\0\4\16\2\0\3\16\1\152"+
    "\1\153\3\0\13\16\1\152\2\16\14\0\4\154\40\0"+
    "\1\143\1\0\1\143\1\0\4\150\6\0\1\145\33\0"+
    "\1\16\1\0\4\155\2\0\5\16\3\0\16\16\12\0"+
    "\1\16\1\0\4\156\2\0\5\16\3\0\16\16\20\0"+
    "\1\157\41\0\1\16\1\0\4\160\2\0\5\16\3\0"+
    "\16\16\12\0\1\16\1\0\4\161\2\0\5\16\3\0"+
    "\16\16\14\0\4\162\42\0\1\16\1\0\4\16\1\157"+
    "\1\0\5\16\3\0\16\16\12\0\1\16\1\0\4\16"+
    "\1\72\1\0\5\16\3\0\16\16\14\0\4\145\32\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[3840];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\5\1\1\11\1\1\1\11\2\1\1\11"+
    "\1\1\2\11\4\1\2\11\10\1\2\0\2\1\1\0"+
    "\13\1\1\11\1\1\1\11\1\1\4\0\3\1\2\0"+
    "\12\1\1\0\1\1\1\0\2\1\1\11\1\1\1\0"+
    "\2\1\1\0\1\1\1\0\2\1\1\0\1\11\1\0"+
    "\1\11\1\0\1\1\1\0\3\1\1\0\3\1\2\0"+
    "\1\11\1\1\1\0\4\1\1\0\2\1\1\0\2\1"+
    "\1\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[114];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  protected int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public _TomlLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _TomlLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return com.intellij.psi.TokenType.BAD_CHARACTER;
            }
          // fall through
          case 21: break;
          case 2:
            { return com.intellij.psi.TokenType.WHITE_SPACE;
            }
          // fall through
          case 22: break;
          case 3:
            { return BASIC_STRING;
            }
          // fall through
          case 23: break;
          case 4:
            { return COMMENT;
            }
          // fall through
          case 24: break;
          case 5:
            { return LITERAL_STRING;
            }
          // fall through
          case 25: break;
          case 6:
            { return COMMA;
            }
          // fall through
          case 26: break;
          case 7:
            { return BARE_KEY;
            }
          // fall through
          case 27: break;
          case 8:
            { return DOT;
            }
          // fall through
          case 28: break;
          case 9:
            { return BARE_KEY_OR_NUMBER;
            }
          // fall through
          case 29: break;
          case 10:
            { return EQ;
            }
          // fall through
          case 30: break;
          case 11:
            { return L_BRACKET;
            }
          // fall through
          case 31: break;
          case 12:
            { return R_BRACKET;
            }
          // fall through
          case 32: break;
          case 13:
            { return L_CURLY;
            }
          // fall through
          case 33: break;
          case 14:
            { return R_CURLY;
            }
          // fall through
          case 34: break;
          case 15:
            { return NUMBER;
            }
          // fall through
          case 35: break;
          case 16:
            { return MULTILINE_BASIC_STRING;
            }
          // fall through
          case 36: break;
          case 17:
            { return MULTILINE_LITERAL_STRING;
            }
          // fall through
          case 37: break;
          case 18:
            { return BOOLEAN;
            }
          // fall through
          case 38: break;
          case 19:
            { return DATE_TIME;
            }
          // fall through
          case 39: break;
          case 20:
            { return BARE_KEY_OR_DATE;
            }
          // fall through
          case 40: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
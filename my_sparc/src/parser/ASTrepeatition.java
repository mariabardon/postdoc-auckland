/* Generated By:JJTree: Do not edit this line. ASTrepeatition.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTrepeatition extends SimpleNode {
  public ASTrepeatition(int id) {
    super(id);
  }

  public ASTrepeatition(SparcTranslator p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SparcTranslatorVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=54161919f7bf7b9b75c7bc06ca600b0d (do not edit this line) */

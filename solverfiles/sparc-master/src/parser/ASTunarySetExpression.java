/* Generated By:JJTree: Do not edit this line. ASTunarySetExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class ASTunarySetExpression extends SimpleNode {
  public ASTunarySetExpression(int id) {
    super(id);
  }

  public ASTunarySetExpression(SparcTranslator p, int id) {
    super(p, id);
  }
  
  public String toString() {
	  switch(((SimpleNode)this.jjtGetChild(0)).getId()) {
	    case SparcTranslatorTreeConstants.JJTCURLYBRACKETS: return ((ASTcurlyBrackets)this.jjtGetChild(0)).toString();
	    case SparcTranslatorTreeConstants.JJTSORTNAME: return "#"+((ASTsortName)this.jjtGetChild(0)).toString();
	    default: return "ASTunarySetExpression";
	  }
  }
}
/* JavaCC - OriginalChecksum=6abf0413ce6fc743f45d4d2a322d82fe (do not edit this line) */

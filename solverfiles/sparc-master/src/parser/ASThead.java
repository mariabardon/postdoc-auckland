/* Generated By:JJTree: Do not edit this line. ASThead.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

import java.util.HashMap;

public
class ASThead extends SimpleNode {
  public ASThead(int id) {
    super(id);
  }

  public ASThead(SparcTranslator p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SparcTranslatorVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  
  @Override
  public String toString(HashMap<String,String> sortRenaming) {
	  SimpleNode child = (SimpleNode)this.jjtGetChild(0);
	  return child.toString(sortRenaming);
	
  }
  
  public String toString() {
	  throw new UnsupportedOperationException();
  }
}
/* JavaCC - OriginalChecksum=b0e8b4e5465e0b317693a6fb01bea4c2 (do not edit this line) */

/* Generated By:JJTree: Do not edit this line. ASTbody.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

import java.util.HashMap;

public
class ASTbody extends SimpleNode {
  public ASTbody(int id) {
    super(id);
  }

  public ASTbody(SparcTranslator p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(SparcTranslatorVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
  
  
  // disallow toString() call without sort renaming map
  @Override
  public String toString() {
	  throw new UnsupportedOperationException();
  }
  
  
  public String toString(HashMap<String,String> sortRenaming) {
	  StringBuilder result=new StringBuilder();
	  for(int i=0;i<this.jjtGetNumChildren();i++) {
		  ASTatom atom=(ASTatom)this.jjtGetChild(i);
		  if(i!=0) {
			  result.append(',');
		  }
		  result.append(atom.toString(sortRenaming));
	  }
	  return result.toString();
  }
}
/* JavaCC - OriginalChecksum=a641cbe4edf43365a9079dc6c1b1fa95 (do not edit this line) */
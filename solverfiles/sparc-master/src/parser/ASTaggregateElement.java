/* Generated By:JJTree: Do not edit this line. ASTaggregateElement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

import java.util.HashMap;

public
class ASTaggregateElement extends SimpleNode {
  public ASTaggregateElement(int id) {
    super(id);
  }

  public ASTaggregateElement(SparcTranslator p, int id) {
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
	  //(n=nonRelAtom() | n=arithmeticTerm())
	  //(< COMMA > (nonRelAtom() | arithmeticTerm()))* [< COLON > extendedSimpleAtomList()]
	  int listIndex=this.jjtGetNumChildren();
	  for(int i=0;i<this.jjtGetNumChildren();i++) {
		  if(((SimpleNode)this.jjtGetChild(i)).getId()
				  ==SparcTranslatorTreeConstants.JJTEXTENDEDSIMPLEATOMLIST) {
			  listIndex=i;
		  }
	  }
	  StringBuilder result=new StringBuilder();
	  for(int i=0;i<listIndex;i++) {
		  if(i!=0)result.append(",");
		  result.append(((SimpleNode)this.jjtGetChild(i)).toString());
	  }
	  if(listIndex!=this.jjtGetNumChildren()) {
		  result.append(":");
		  result.append(((ASTextendedSimpleAtomList)this.jjtGetChild(listIndex)).toString(sortRenaming));
	  }
	  return result.toString();
	  
  }
}
/* JavaCC - OriginalChecksum=8d7f5d0e200aad389d2e07561513c04b (do not edit this line) */

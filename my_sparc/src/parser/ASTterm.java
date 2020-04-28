/* Generated By:JJTree: Do not edit this line. ASTterm.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

import java.util.ArrayList;

import utilities.Pair;
import warnings.StringListUtils;

public class ASTterm extends SimpleNode {
	public ASTterm(int id) {
		super(id);
	}

	public ASTterm(SparcTranslator p, int id) {
		super(p, id);
	}

	public ASTterm(long value) {
		super(SparcTranslatorTreeConstants.JJTTERM);
		this.jjtAddChild(new ASTarithmeticTerm(value), 0);

	}

	public ASTterm(String image) {
		super(SparcTranslatorTreeConstants.JJTTERM);
		Pair<String, ArrayList<String>> recordContents = StringListUtils
				.splitTerm(image);
		if (recordContents != null) {
			ASTsymbolicFunction func = new ASTsymbolicFunction(
					SparcTranslatorTreeConstants.JJTSYMBOLICFUNCTION);
			func.image = recordContents.first + "(";
			ASTtermList termList = new ASTtermList(
					SparcTranslatorTreeConstants.JJTTERMLIST);
			for (int i = 0; i < recordContents.second.size(); i++) {
				ASTterm newTerm = new ASTterm(recordContents.second.get(i));
				termList.jjtAddChild(newTerm, i);
			}
			ASTsymbolicTerm sterm = new ASTsymbolicTerm(
					SparcTranslatorTreeConstants.JJTSYMBOLICTERM);
			sterm.jjtAddChild(func, 0);
			sterm.jjtAddChild(termList, 1);
			this.jjtAddChild(sterm, 0);
		} else {
            if(isNumericConstant(image)) {
            	this.jjtAddChild(new ASTarithmeticTerm(Long.parseLong(image)), 0);
            }
            else if (!Character.isLowerCase(image.charAt(0))) {
				ASTvar var = new ASTvar(SparcTranslatorTreeConstants.JJTVAR);
				var.image = image;
				this.jjtAddChild(var, 0);
			} else {
				ASTsymbolicConstant sconstant = new ASTsymbolicConstant(
						SparcTranslatorTreeConstants.JJTSYMBOLICCONSTANT);
				sconstant.image = image;
				ASTsymbolicTerm sterm = new ASTsymbolicTerm(
						SparcTranslatorTreeConstants.JJTSYMBOLICTERM);
				sterm.jjtAddChild(sconstant, 0);
				this.jjtAddChild(sterm, 0);
			}
		}
	}

	public ASTterm(String recordName, ArrayList<String> varArgs) {
		super(SparcTranslatorTreeConstants.JJTTERM);
		ASTsymbolicFunction symFunction = new ASTsymbolicFunction(
				SparcTranslatorTreeConstants.JJTSYMBOLICFUNCTION);
		symFunction.image = recordName + "(";

		ASTtermList termList = new ASTtermList(
				SparcTranslatorTreeConstants.JJTTERMLIST);

		for (int i = 0; i < varArgs.size(); i++) {
			ASTterm term = new ASTterm(SparcTranslatorTreeConstants.JJTTERM);
			ASTvar var = new ASTvar(SparcTranslatorTreeConstants.JJTVAR);
			var.image = varArgs.get(i);
			term.jjtAddChild(var, 0);
			termList.jjtAddChild(term, i);
		}

		ASTsymbolicTerm sterm = new ASTsymbolicTerm(
				SparcTranslatorTreeConstants.JJTSYMBOLICTERM);
		sterm.jjtAddChild(symFunction, 0);
		sterm.jjtAddChild(termList, 1);
		this.jjtAddChild(sterm, 0);
	}

	public ASTterm(ASTvar newVar) {
		super(SparcTranslatorTreeConstants.JJTTERM);
		this.jjtAddChild(newVar, 0);
		// TODO Auto-generated constructor stub
	}
	
	public static ASTterm createArithmeticVarTerm(ASTvar var) {
		ASTterm term=new ASTterm(SparcTranslatorTreeConstants.JJTTERM);
		ASTarithmeticTerm arTerm=new ASTarithmeticTerm(SparcTranslatorTreeConstants.JJTARITHMETICTERM);
		ASTadditiveArithmeticTerm adTerm=new ASTadditiveArithmeticTerm(SparcTranslatorTreeConstants.JJTADDITIVEARITHMETICTERM);
		adTerm.image="+";
		ASTmultiplicativeArithmeticTerm multTerm=new ASTmultiplicativeArithmeticTerm(SparcTranslatorTreeConstants.JJTMULTIPLICATIVEARITHMETICTERM);
		ASTatomicArithmeticTerm atTerm=new ASTatomicArithmeticTerm(SparcTranslatorTreeConstants.JJTATOMICARITHMETICTERM);
		atTerm.image="";
		atTerm.jjtAddChild(var, 0);
		multTerm.jjtAddChild(atTerm, 0);
		adTerm.jjtAddChild(multTerm, 0);
		arTerm.jjtAddChild(adTerm, 0);
		term.jjtAddChild(arTerm, 0);
		return term;
	}

	
	
	public ASTterm(ASTadditiveArithmeticTerm arAdTerm) {
		super(SparcTranslatorTreeConstants.JJTTERM);
		ASTarithmeticTerm arTerm=new ASTarithmeticTerm(SparcTranslatorTreeConstants.JJTARITHMETICTERM);
		arTerm.jjtAddChild(arAdTerm, 0);
		this.jjtAddChild(arTerm, 0);
	}

	/** Accept the visitor. **/
	public Object jjtAccept(SparcTranslatorVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}

	/**
	 * Check if this term has variables
	 * 
	 * @return true if it has and false otherwise
	 */
	public boolean hasVariables() {
		return hasVariables((SimpleNode) this);
	}

	/**
	 * Check if SimpleNode has variables
	 * 
	 * @param n
	 *            SimpleNode to check
	 * @return true if it has and false otherwise
	 */
	private boolean hasVariables(SimpleNode n) {
		if (n.getId() == SparcTranslatorTreeConstants.JJTVAR) {
			return true;
		}
		boolean result = false;
		for (int i = 0; i < n.jjtGetNumChildren(); i++) {
			if (hasVariables((SimpleNode) n.jjtGetChild(i))) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * Check if the terms has arithmetic operations
	 * 
	 * @return true if it has an arithmetic operation ( +,-,*,/) and false
	 *         otherwise
	 */
	public boolean hasArithmeticOperations() {
		String termString = this.toString();
		String operations = "+-*/";
		for (char c : operations.toCharArray()) {
			if (termString.indexOf(c) != -1)
				return true;
		}
		return false;
	}

	/**
	 * Check if the term is ground
	 * 
	 * @return true or false
	 */
	public boolean isGround() {
		return !hasArithmeticOperations() && !hasVariables();
	}

	private static boolean isNumericConstant(String image) {
		for (int i = 0; i < image.length(); i++) {
			if (i == 0 && image.charAt(i) < '1' || image.charAt(i) > '9') {
				return false;
			} else {
				if (image.charAt(i) < '0' || image.charAt(i) > '9')
					return false;
			}
		}
		return true;
	}

	public boolean isVariable() {
		SimpleNode child = (SimpleNode) this.jjtGetChild(0);
		return child.getId() == SparcTranslatorTreeConstants.JJTVAR;
	}

	public boolean isRecord() {
		SimpleNode child = (SimpleNode) this.jjtGetChild(0);
		if (child.getId() == SparcTranslatorTreeConstants.JJTSYMBOLICTERM) {
			SimpleNode childOfChild = (SimpleNode) child.jjtGetChild(0);
			return childOfChild.getId() == SparcTranslatorTreeConstants.JJTSYMBOLICFUNCTION;
		} else {
			return false;
		}
	}
	
	public String getRecordName() {
		
		if(!isRecord()) {
			throw new IllegalArgumentException();
		}
		
		SimpleNode symTerm = (SimpleNode) this.jjtGetChild(0);
		SimpleNode symFunc = (SimpleNode) symTerm.jjtGetChild(0);
		return symFunc.image.substring(0,symFunc.image.length()-1); 
		
		
	}
	
	public ArrayList<ASTterm> getRecordArgs() {
		
		if(!isRecord()) {
			throw new IllegalArgumentException();
		}
		
		SimpleNode symTerm = (SimpleNode) this.jjtGetChild(0);
		SimpleNode symTermList = (SimpleNode) symTerm.jjtGetChild(1);
		ArrayList<ASTterm> result = new ArrayList<ASTterm>();
		for(int i=0;i<symTermList.jjtGetNumChildren();i++) {
			result.add((ASTterm)symTermList.jjtGetChild(i));
		}
		return result;
	}
	

	public String toString() {
		return toString(false);
	}

	public String toString(boolean useOriginalImages) {
		if (this.jjtGetNumChildren() == 0) {
			return this.image;
		} else
			return ((SimpleNode) (this.jjtGetChild(0)))
					.toString(useOriginalImages);
	}
	
	public ASTmultiplicativeArithmeticTerm getLeftMostMultiplicativeTerm() {
		ASTarithmeticTerm arTerm=(ASTarithmeticTerm)this.jjtGetChild(0);
		ASTadditiveArithmeticTerm adTerm=(ASTadditiveArithmeticTerm)arTerm.jjtGetChild(0);
		return (ASTmultiplicativeArithmeticTerm)adTerm.jjtGetChild(0);
		
	}
	
	public ASTatomicArithmeticTerm getLeftMostAtomicTerm() {
		ASTmultiplicativeArithmeticTerm mTerm=getLeftMostMultiplicativeTerm();
		return (ASTatomicArithmeticTerm)mTerm.jjtGetChild(0);
	}
}
/*
 * JavaCC - OriginalChecksum=c1ac1ba327197118b424963735d16a51 (do not edit this
 * line)
 */

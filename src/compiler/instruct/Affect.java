package compiler.instruct;

import compiler.Expression;

public class Affect extends Instruction {

	protected String idf;
	protected Expression exp;
	
	public Affect(Expression exp) {
		this.exp = exp;
	}
	
	public String getSourceCode() {
		StringBuilder sb= new StringBuilder();
		sb.append(idf + " = " + exp.getSourceCode());
		return null;
	}

}

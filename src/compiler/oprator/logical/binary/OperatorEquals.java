package compiler.oprator.logical.binary;

import compiler.Expression;

public class OperatorEquals extends LogicalBinaryOperator {

	public OperatorEquals(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" = ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	public String getOpCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("#egual a \n");
		sb.append("beq $v0, $t8, iftrue\n");//TODO incrementer le else 
		sb.append("li $v0, 0\n");
		sb.append("j fin\n");//TODO incrementer le fin
		sb.append("iftrue :\n");
		sb.append("li $v0, 1\n");
		sb.append("fin :\n");//TODO incrementer le fin
		return sb.toString();
	}
}

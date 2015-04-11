package compiler.operator.logical.binary;

import compiler.Expression;

public class OperatorInferior extends LogicalBinaryOperator {

	public OperatorInferior(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" < ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	public String getOpCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("#et suppérieur à \n");
		sb.append("blt $v0, $t8, iftrue\n");//TODO incrementer le else 
		sb.append("li $v0, 0\n");
		sb.append("j fin\n");//TODO incrementer le fin
		sb.append("iftrue :\n");
		sb.append("li $v0, 1\n");
		sb.append("fin :\n");//TODO incrementer le fin
		return sb.toString();
	}
}

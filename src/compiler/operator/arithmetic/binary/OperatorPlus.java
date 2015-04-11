package compiler.operator.arithmetic.binary;

import compiler.Expression;


public class OperatorPlus extends ArithmeticBinaryOperator {

	public OperatorPlus(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" + ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	public String getOpCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("#addition \n");
		sb.append("add $v0, $t8, $v0\n");
		return sb.toString();
	}

}

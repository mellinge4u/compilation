package compiler.oprator.arithmetic.binary;

import compiler.Expression;


public class OperatorMulti extends ArithmeticBinaryOperator {

	public OperatorMulti(Expression expL, Expression expR) {
		super(expL, expR);
	}

	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" * ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	public String getOpCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("#multiplication \n");
		sb.append("mul $v0, $t8, $v0\n");
		return sb.toString();
	}

}

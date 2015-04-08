package compiler.oprator.arithmetic.binary;

import compiler.Expression;


public class OperatorMulti extends ArithmeticBinaryOperator {

	public OperatorMulti(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getDecoretedCode() {
		// TODO ecrire le bon code
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getDecoretedCode());
		sb.append(" * ");
		sb.append(expRight.getDecoretedCode());
		sb.append(")");
		return sb.toString();
	}

}

package compiler.oprator.arithmetic.unary;

import compiler.Expression;


public class OperatorUnaryMinus extends ArithmeticUnaryOperator {

	public OperatorUnaryMinus(Expression exp) {
		super(exp);
	}

	@Override
	public String getDecoretedCode() {
		// TODO ecrire le bon code
		StringBuilder sb = new StringBuilder();
		sb.append("-");
		sb.append(exp.getDecoretedCode());
		return sb.toString();
	}

}

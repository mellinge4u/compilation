package compiler.oprator.arithmetic.unary;

import compiler.Expression;


public class OperatorUnaryMinus extends ArithmeticUnaryOperator {

	public OperatorUnaryMinus(Expression exp) {
		super(exp);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("-");
		sb.append(exp.getSourceCode());
		return sb.toString();
	}

	@Override
	public String getCompiledCode() {
		// TODO Auto-generated method stub
		return exp.getCompiledCode();
	}

}

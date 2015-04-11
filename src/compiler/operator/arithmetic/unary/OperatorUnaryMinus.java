package compiler.operator.arithmetic.unary;

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
	public String getOpCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("#creation de -"+exp.getSourceCode()+" \n");
		sb.append("li, $t8, 0\n");
		sb.append("sub $v0, $t8, $v0\n");
		return sb.toString();
	}

}

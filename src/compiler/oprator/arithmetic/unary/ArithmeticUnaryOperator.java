package compiler.oprator.arithmetic.unary;

import compiler.Expression;

public abstract class ArithmeticUnaryOperator extends Expression {

	protected Expression exp;

	public ArithmeticUnaryOperator(Expression exp) {
		this.exp = exp;
	}
}

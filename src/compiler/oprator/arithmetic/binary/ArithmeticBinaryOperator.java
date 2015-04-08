package compiler.oprator.arithmetic.binary;

import compiler.Expression;

public abstract class ArithmeticBinaryOperator extends Expression {

	protected Expression expLeft;
	protected Expression expRight;
	
	public ArithmeticBinaryOperator(Expression expL, Expression expR) {
		expLeft = expL;
		expRight = expR;
	}

}

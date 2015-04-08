package compiler.oprator.logical.binary;

import compiler.Expression;

public abstract class LogicalBinaryOperator extends Expression {

	protected Expression expRight;
	protected Expression expLeft;

	public LogicalBinaryOperator(Expression expL, Expression expR) {
		expLeft = expL;
		expRight = expR;
	}
}

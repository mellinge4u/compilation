package compiler.oprator.logical.binary;

import compiler.Expression;

public class OperatorSuperior extends LogicalBinaryOperator {

	public OperatorSuperior(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" > ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String getCompiledCode() {
		// TODO Auto-generated method stub
		return null;
	}
}

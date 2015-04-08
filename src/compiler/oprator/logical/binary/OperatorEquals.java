package compiler.oprator.logical.binary;

import compiler.Expression;

public class OperatorEquals extends LogicalBinaryOperator {

	public OperatorEquals(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" = ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String getCompiledCode() {
		// TODO Auto-generated method stub
		return expLeft.getCompiledCode() + expRight.getCompiledCode();
	}
}

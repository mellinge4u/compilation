package compiler.oprator.arithmetic.binary;

import compiler.Expression;


public class OperatorMinus extends ArithmeticBinaryOperator {

	public OperatorMinus(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" - ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	public String getOpCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("#soustraction \n");
		sb.append("sub $v0, $t8, $v0\n");
		return sb.toString();
	}
	
}

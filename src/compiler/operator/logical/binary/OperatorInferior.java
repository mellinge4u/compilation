package compiler.operator.logical.binary;

import compiler.Compteur;
import compiler.Expression;

public class OperatorInferior extends LogicalBinaryOperator {

	public OperatorInferior(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getSourceCode());
		sb.append(" < ");
		sb.append(expRight.getSourceCode());
		sb.append(")");
		return sb.toString();
	}

	public String getOpCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		sb.append("#et supp�rieur � \n");
		sb.append("blt $v0, $t8, iftrue" + i.getValue() + "\n"); 
		sb.append("li $v0, 0\n");
		sb.append("j fin" + i.getValue() + "\n");
		sb.append("iftrue" + i.getValue() + " :\n");
		sb.append("li $v0, 1\n");
		sb.append("fin" + i.getValue() + " :\n");
		i.increment();
		return sb.toString();
	}
}

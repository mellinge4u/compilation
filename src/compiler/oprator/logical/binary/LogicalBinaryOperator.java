package compiler.oprator.logical.binary;

import compiler.Expression;

public abstract class LogicalBinaryOperator extends Expression {

	protected Expression expRight;
	protected Expression expLeft;

	public LogicalBinaryOperator(Expression expL, Expression expR) {
		expLeft = expL;
		expRight = expR;
	}

	public abstract String getOpCode();

	public String getCompiledCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(expLeft.getCompiledCode());
		sb.append("#Code cible qui évalue l'expression gauche et la stocke dans $v0 \n");
		sb.append("sw $v0, ($sp)\n");
		sb.append("addi $sp, $sp, -4\n");
		sb.append(expRight.getCompiledCode());
		sb.append("#Code cible qui évalue l'expression droite et la stocke dans $v0 \n");
		sb.append("addi $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("# realisation de l'opération demandé pour les opérations artihmétiques binaires \n");
		sb.append(this.getOpCode());
		return sb.toString();

	}
}

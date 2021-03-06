package compiler.operator.logical.binary;

import compiler.Compteur;
import compiler.Expression;

public abstract class LogicalBinaryOperator extends Expression {

	protected Expression expRight;
	protected Expression expLeft;

	public LogicalBinaryOperator(Expression expL, Expression expR) {
		expLeft = expL;
		expRight = expR;
	}

	public abstract String getOpCode(Compteur i);

	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		sb.append(expLeft.getCompiledCode(i));
		sb.append("#Code cible qui �value l'expression gauche et la stocke dans $v0 \n");
		sb.append("sw $v0, ($sp)\n");
		sb.append("addi $sp, $sp, -4\n");
		sb.append(expRight.getCompiledCode(i));
		sb.append("#Code cible qui �value l'expression droite et la stocke dans $v0 \n");
		sb.append("addi $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("# realisation de l'op�ration demand� pour les op�rations artihm�tiques binaires \n");
		sb.append(this.getOpCode(i));
		return sb.toString();

	}
}

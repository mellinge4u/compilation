package compiler.operator.arithmetic.binary;

import compiler.Compteur;
import compiler.Expression;

public abstract class ArithmeticBinaryOperator extends Expression {

	protected Expression expLeft;
	protected Expression expRight;
	
	public ArithmeticBinaryOperator(Expression expL, Expression expR) {
		expLeft = expL;
		expRight = expR;
	}

	public abstract String getOpCode();
	
	public String getCompiledCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		sb.append(expLeft.getCompiledCode(i));
		sb.append("#Code cible qui évalue l'expression gauche et la stocke dans $v0 \n");
		sb.append("sw $v0, ($sp)\n");
		sb.append("addi $sp, $sp, -4\n");
		sb.append(expRight.getCompiledCode(i));
		sb.append("#Code cible qui évalue l'expression droite et la stocke dans $v0 \n");
		sb.append("addi $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("# realisation de l'opération demandé pour les opérations artihmétiques binaires \n");
		sb.append(this.getOpCode());
		return sb.toString();
		
	}
	
}

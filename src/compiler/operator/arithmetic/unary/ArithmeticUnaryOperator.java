package compiler.operator.arithmetic.unary;

import compiler.Expression;

public abstract class ArithmeticUnaryOperator extends Expression {

	protected Expression exp;

	public ArithmeticUnaryOperator(Expression exp) {
		this.exp = exp;
	}
	
public abstract String getOpCode();
	
	public String getCompiledCode(){
		StringBuilder sb = new StringBuilder();
		sb.append(exp.getCompiledCode());
		sb.append("#Code cible qui �value l'expression droite et la stocke dans $v0 \n");
		sb.append("addi $sp, $sp, 4\n");
		sb.append("lw $t8, ($sp)\n");
		sb.append("# realisation de l'op�ration demand� pour les op�rations artihm�tiques binaires \n");
		sb.append(this.getOpCode());
		return sb.toString();
		
	}
}

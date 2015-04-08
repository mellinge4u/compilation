package compiler.oprator.arithmetic.binary;

import compiler.Expression;


public class OperatorMinus extends ArithmeticBinaryOperator {

	public OperatorMinus(Expression expL, Expression expR) {
		super(expL, expR);
	}

	@Override
	public String getDecoretedCode() {
		// TODO ecrire le bon code
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(expLeft.getDecoretedCode());
		sb.append(" - ");
		sb.append(expRight.getDecoretedCode());
		sb.append(")");
		return sb.toString();
	}

	public String genererCode(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.get.genererCode());
		sb.append("#Code cible qui évalue l'expression gauche et la stocke dans $v0 ");
		sb.append("sw $v0, (sp)\n");
		sb.append("addi $sp, $sp-4\n");
		return sb.toString();
	}
	
}

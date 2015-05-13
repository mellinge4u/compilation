package compiler.instruct;

import compiler.Compteur;
import compiler.Expression;

public class EcrireExp extends Ecrire {

	protected Expression exp;
	
	public EcrireExp(Expression exp) {
		this.exp = exp;
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("ecrire " + exp.getSourceCode() + ";\n");
		return sb.toString();
	}

	@Override
	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		exp.getCompiledCode(i);
		sb.append("# ecrire une chaine de caractères \n"
				+ "sw $v0, ($sp)\n"
				+ "addi $sp, $sp, -4\n"
				+ "li $v0 , 1 # $v0 <- code du print \n"
				+ "lw $t8, 4($sp) 	# $a0 <- adresse de la chaîne à écrire\n"
				+ "syscall 	# afficher\n"
				+ "addi $sp, $sp, 4");
		return sb.toString();
	}
}

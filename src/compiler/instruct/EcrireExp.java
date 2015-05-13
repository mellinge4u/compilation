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
		sb.append("ecrire " + exp.getSourceCode() + " ;");
		return sb.toString();
	}

	@Override
	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		exp.getCompiledCode(i);
		sb.append("# ecrire une chaine de caractères \n"
				+ "li $v0 , 1 # $v0 <- code du print \n"
				+ "li $t8, $v0 	# $a0 <- adresse de la chaîne à écrire\n"
				+ "syscall 	# afficher\n");
		return sb.toString();
	}
}

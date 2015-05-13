package compiler.instruct;

import compiler.Compteur;
import compiler.Data;

public class EcrireChaine extends Ecrire {

	protected String chaine;
	
	public EcrireChaine(String chaine) {
		this.chaine = chaine;
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("ecrire " + chaine + ";\n");
		return sb.toString();
	}

	@Override
	public String getCompiledCode(Compteur i) {
		Data.getInstance().append("str"+i.getValue()+": .asciiz "+chaine +"\n");
		StringBuilder sb = new StringBuilder();
		sb.append("li $v0, 4 	# $v0 <- code du print\n"
				+"la $a0, str"+i.getValue()+" 	# $a0 <- adresse de la chaîne à écrire\n"
		+"syscall 	# afficher\n");
		i.increment();
		return null;
	}

}

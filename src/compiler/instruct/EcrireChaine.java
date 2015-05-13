package compiler.instruct;

import compiler.Compteur;

public class EcrireChaine extends Ecrire {

	protected String chaine;
	
	public EcrireChaine(String chaine) {
		this.chaine = chaine;
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("ecrire " + chaine + " ;");
		return sb.toString();
	}

	@Override
	public String getCompiledCode(Compteur i) {
		// TODO Auto-generated method stub
		return null;
	}

}

package compiler;

public class Classe extends Systeme {

	protected String idf;
	protected Declaration decl;
	
	public Classe(String idf, Declaration decl) {
		this.idf = idf;
		this.decl = decl;
	}
}

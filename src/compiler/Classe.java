package compiler;

import java.util.ArrayList;

public class Classe extends Systeme {

	protected String idf;
	protected ArrayList<Declaration> decls;
	
	public Classe(String idf) {
		this.idf = idf;
		decls = new ArrayList<Declaration>();
	}

	public void addDeclaration(Declaration decl) {
		decls.add(decl);
	}
	
	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("classe " + idf + '\n');
		for (Declaration decl : decls) {
			sb.append(decl.getSourceCode() + '\n');
		}
		sb.append("fin");
		return sb.toString();
	}
	

}

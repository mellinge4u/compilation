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
	
	public void addListDecl(ArrayList<Declaration> listDecl) {
		decls.addAll(listDecl);
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
	

	public String getCompiledCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		sb.append("# Class "+idf+"\n");
		sb.append(Data.getInstance().getData()+"\n");// le .data
		sb.append(".text\n");
		sb.append("main:\n");
		for(Declaration d : decls){
			sb.append(d.getCompiledCode(i));
		}
		sb.append("#Fin du programme \n");
		sb.append("li $v0 , 5\n");
		sb.append("syscall #retour au systeme\n");
		return sb.toString();
	}
	
}

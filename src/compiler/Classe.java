package compiler;

import java.util.ArrayList;

import compiler.tds.TableDesSymboles;

public class Classe extends Systeme {

	protected String idf;
	protected ArrayList<Declaration> decls;
	
	public Classe(String idf) {
		this.idf = idf;
		decls = new ArrayList<Declaration>();
		TableDesSymboles tds = TableDesSymboles.getInstance();
		tds.entreeBloc();
	}

	public void addDeclaration(Declaration decl) {
		decls.add(decl);
	}
	
	public void addListDecl(ArrayList<Declaration> listDecl) {
		decls.addAll(listDecl);
	}
	
	public void finClass() {
		TableDesSymboles tds = TableDesSymboles.getInstance();
		tds.sortieBloc();
	}
	
	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("classe " + idf + '\n');
		for (Declaration decl : decls) {
			sb.append(decl.getSourceCode());
		}
		sb.append("fin");
		return sb.toString();
	}
	

	public String getCompiledCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		
		sb.append(".text\n");
		sb.append("main:\n");
		sb.append("# Initialisation de s7\n");
		sb.append("move $s7 , $sp\n");
		for(Declaration d : decls){
			sb.append(d.getCompiledCode(i));
		}
		sb.append("#Fin du programme \n");
		sb.append("li $v0 , 5\n");
		sb.append("syscall #retour au systeme\n");
		sb.insert(0,Data.getInstance().getData()+"\n");
		sb.insert(0,"# Class "+idf+"\n");
		return sb.toString();
	}
	
}

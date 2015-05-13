package compiler.instruct;

import compiler.Compteur;
import compiler.Data;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Lire extends Instruction {

	protected String idf;
	protected TableDesSymboles tds;

	public Lire(String idf){
		this.idf = idf;
	}
	
	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("lire " + idf + ";\n");
		return sb.toString();
	} 
	
	public String getCompiledCode(Compteur i){
		//Data.getInstance().append("lus"+i.getValue()+": .space 256");
		Symbol s = TableDesSymboles.getInstance().identifier(idf);
		int adDm = s.getOrigine();
		StringBuilder sb = new StringBuilder();
		sb.append("# Lire une chaine de caractères\n"
	+"li $v0, 5 	# $v0 <- code du read\n"
	+"syscall 	# lire\n"
	+"sw $v0, "+adDm+"($s7)\n" );
		return sb.toString();
		
	}
	
}

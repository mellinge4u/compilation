package compiler.instruct;

import compiler.Compteur;
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
		sb.append("lire " + idf + " ;");
		return sb.toString();
	} 
	
	public String getCompiledCode(Compteur i){
		
		Symbol s = TableDesSymboles.getInstance().identifier(idf);
		int adDm = s.getOrigine();
		StringBuilder sb = new StringBuilder();
		sb.append("# Lire une chaine de caractères\n"
	+"li $v0, 8 	# $v0 <- code du read\n"
	+"la $a0, lus 	# $a0 <- adresse de la chaîne à écrire\n"
	+"li $a1, "+adDm+" 	# $v0 <- nombre de caractères à lire\n"
	+"syscall 	# lire\n");
		return sb.toString();
		
	}
	
}

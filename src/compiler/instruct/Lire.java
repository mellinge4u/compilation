package compiler.instruct;

import compiler.Compteur;
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
		
		
		return idf;
		
	}
	
}

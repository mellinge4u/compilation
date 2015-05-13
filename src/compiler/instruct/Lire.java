package compiler.instruct;

public class Lire extends Instruction {

	protected String idf;

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("lire " + idf + " ;");
		return sb.toString();
	} 
	
}

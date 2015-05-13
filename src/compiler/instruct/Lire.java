package compiler.instruct;

public class Lire extends Instruction {

	protected String idf;

	public Lire(String idf){
		this.idf = idf;
	}
	
	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("lire " + idf + " ;");
		return sb.toString();
	} 
	
}

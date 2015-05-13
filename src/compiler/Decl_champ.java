package compiler;

import java.util.ArrayList;

public class Decl_champ extends Declaration {

	public enum e_status {publique, privee};
	public enum e_type {entier};
	protected e_status status;
	protected e_type type;
	protected ArrayList<String> idfs;
	
	public Decl_champ(e_status status, e_type type, String idf) {
		this.status = status;
		this.type = type;
		idfs = new ArrayList<String>();
		idfs.add(idf);
	}

	public void addIdf(String idf) {
		idfs.add(idf);
	}
	
	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(status);
		sb.append(" " + type);
		sb.append(idfs.get(0));
		for (int i = 1; i < idfs.size(); i++) {
			sb.append(", " + idfs.get(1));
		}
		sb.append(" ;");
		return sb.toString();
	}

	public String getCompiledCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("#on reserve de la mémoire en empliantn\n");
		sb.append("addi $sp, $sp -4");
		return null;
	}
	
}

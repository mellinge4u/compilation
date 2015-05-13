package compiler;

import java.util.ArrayList;

public class Decl_champ extends Declaration {

	public enum e_status {publique, privee};
	public enum e_type {entier};
	protected e_status status;
	protected e_type type;
	protected ArrayList<String> idfs;
	
	public Decl_champ(String status, String type, String idf) {
		if (status == "publique") {
			this.status = e_status.publique;
		} else if (status == "privee") {
			this.status = e_status.privee;
		} else {
			throw new DevlopperErrorException("Probleme avec Jflex et cup sur les status\n");
		}
		if (type == "entier") {
			this.type = e_type.entier;
		} else {
			throw new DevlopperErrorException("Probleme avec Jflex et cup sur les types\n");
		}
		idfs = new ArrayList<String>();
		idfs.add(idf);
	}

	public void addIdf(String idf) {
		idfs.add(idf);
	}
	
	public void addListIdf(ArrayList<String> idfs) {
		this.idfs.addAll(idfs);
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

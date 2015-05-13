package compiler;

import java.util.ArrayList;

import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Decl_champ extends Declaration {

	protected Symbol.e_visibility status;
	protected String type;
	protected ArrayList<String> idfs;
	protected static TableDesSymboles tds = TableDesSymboles.getInstance();

	public Decl_champ(String status, String type, String idf) {
		if (status.equals("publique")) {
			this.status = Symbol.e_visibility.publique;
		} else if (status.equals("privee")) {
			this.status = Symbol.e_visibility.privee;
		} else {
			throw new DevlopperErrorException(
					"Probleme avec Jflex et cup sur les status\n");
		}
		this.type = type;
		tds.ajouter(idf, new Symbol(type, this.status));

		idfs = new ArrayList<String>();
		idfs.add(idf);
	}

	public void addIdf(String idf) {
		tds.ajouter(idf, new Symbol(type, this.status));
		idfs.add(idf);
	}

	public void addListIdf(ArrayList<String> idfs) {
		for (String idf : idfs) {
			tds.ajouter(idf, new Symbol(type, this.status));
		}
		this.idfs.addAll(idfs);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(status);
		sb.append(" " + type);
		sb.append(" " + idfs.get(0));
		for (int i = 1; i < idfs.size(); i++) {
			sb.append(", " + idfs.get(1));
		}
		sb.append(";\n");
		return sb.toString();
	}

	public String getCompiledCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		int origin;
		if (type.equals("entier")) {		
			origin = -4;
		} else {
			throw new DevlopperErrorException("Problème avec le type d'une variable sur la génération du code Mips\n");
		}
		sb.append("#on reserve de la mémoire en empliantn\n");
		sb.append("addi $sp, $sp ," + origin + "\n");
		return sb.toString();
	}

	
}

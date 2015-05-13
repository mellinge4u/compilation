package compiler;

import java.util.ArrayList;

import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Decl_champ extends Declaration {

	public enum e_type {
		entier
	};

	protected Symbol.e_visibility status;
//	protected e_type type;	// TODO Definir le type de type
	protected String type;
	protected ArrayList<String> idfs;
	protected static TableDesSymboles tds = TableDesSymboles.getInstance();

	public Decl_champ(String status, String type, String idf) {
		if (status == "publique") {
			this.status = Symbol.e_visibility.publique;
		} else if (status == "privee") {
			this.status = Symbol.e_visibility.privee;
		} else {
			throw new DevlopperErrorException(
					"Probleme avec Jflex et cup sur les status\n");
		}
		
		tds.ajouter(idf, new Symbol(type, this.status));
		
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
		int origin;
		switch (type) {
		case entier:
			origin = -4;
			break;
		default:
			throw new DevlopperErrorException("Probl�me avec le type d'une variable sur la g�n�ration du code Mips\n")
			origin = 0;
			break;
		}
		sb.append("#on reserve de la m�moire en empliantn\n");
		sb.append("addi $sp, $sp " + origin);
		return null;
	}
}

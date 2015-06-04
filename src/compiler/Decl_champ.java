package compiler;

import java.util.ArrayList;

import compiler.exception.DevlopperErrorException;
import compiler.exception.DoubleDeclarationException;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Decl_champ extends Declaration {

	protected Symbol.e_visibility status;
	protected String type;
	protected ArrayList<String> idfs;
	protected int bloc;
	protected static TableDesSymboles tds = TableDesSymboles.getInstance();
	protected Boolean doubleDecl;
	
	public Decl_champ(String status, String type, String idf) {
		bloc = tds.getNumeroBloc();
		doubleDecl = false;
		if (status.equals("publique")) {
			this.status = Symbol.e_visibility.publique;
		} else if (status.equals("privee")) {
			this.status = Symbol.e_visibility.privee;
		} else {
			throw new DevlopperErrorException(
					"Probleme avec Jflex et cup sur les status\n");
		}
		this.type = type;

		try {
			tds.ajouter(idf, new Symbol(type, this.status));
		} catch (DoubleDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \""
					+ e.getMessage() + "\" deja déclarée");
			doubleDecl = true;
		}

		idfs = new ArrayList<String>();
		idfs.add(idf);
	}

	public void addIdf(String idf) {
		try {
			tds.ajouter(idf, new Symbol(type, this.status));
		} catch (DoubleDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \""
					+ e.getMessage() + "\" deja déclarée");
			doubleDecl = true;
		}
		idfs.add(idf);
	}

	public void addListIdf(ArrayList<String> idfs) {
		for (String idf : idfs) {
			try {
				tds.ajouter(idf, new Symbol(type, this.status));
			} catch (DoubleDeclarationException e) {
				System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \""
						+ e.getMessage() + "\" deja déclarée");
				doubleDecl = true;
			}
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

	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		TableDesSymboles tds = TableDesSymboles.getInstance();
		int origin;
		for (String idf : idfs) {
			sb.append("#on reserve de la mémoire pour " + idf + " en empliant\n");
			if (!doubleDecl) {
				origin = tds.identifier(idf, bloc).getOrigine();
				sb.append("addi $sp, $sp ," + origin + "\n");
			} else {
				sb.append("\t# La variable " + idf + " a déja été déclarée,\n");
				sb.append("\t#   et sa mémoire est déja réservée\n");
			}
		}
		return sb.toString();
	}

}

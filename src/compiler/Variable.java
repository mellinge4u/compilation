package compiler;

import compiler.exception.UndeclaredDeclarationException;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;


public class Variable extends Expression {

	protected String idf;
	
	public Variable(String idf) {
		this.idf = idf;
	}

	public String getIdf() {
		return idf;
	}

	public void setIdf(String idf) {
		this.idf = idf;
	}

	public String getSourceCode() {
		return idf;
	}

	public String getCompiledCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		TableDesSymboles tds = TableDesSymboles.getInstance();
		sb.append("#stockage de la variable " + idf + " dans le registre $v0\n");

		if (tds.existeDeja(idf)) {
		Symbol sym = tds.identifier(idf);
		int ad = sym.getOrigine();
		sb.append("lw $v0, " + ad + "($s7)\n");
		} else {
			sb.append("# ERR : L'identificateur " + idf + " n'est pas déclarée");
			System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \""
					+ idf + "\" non déclarée");
	}
		
		return sb.toString();
	}
	
}

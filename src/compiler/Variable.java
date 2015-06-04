package compiler;

import compiler.exception.UndeclaredDeclarationException;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Variable extends Expression {

	protected String idf;
	protected int bloc;

	public Variable(String idf) {
		this.idf = idf;
		this.bloc = TableDesSymboles.getInstance().getNumeroBloc();
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

	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		TableDesSymboles tds = TableDesSymboles.getInstance();
		sb.append("#stockage de la variable " + idf + " dans le registre $v0\n");

		try {
			Symbol sym = tds.identifier(idf, bloc);
			int ad = sym.getOrigine();
			sb.append("lw $v0, " + ad + "($s7)\n");
		} catch (UndeclaredDeclarationException e) {
			sb.append("# ERR : L'identificateur " + idf + " n'est pas déclarée");
			System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \"" + idf
					+ "\" non déclarée");
		}

		return sb.toString();
	}

	public int getBloc() {
		return bloc;
	}

	public void setBloc(int bloc) {
		this.bloc = bloc;
	}

}

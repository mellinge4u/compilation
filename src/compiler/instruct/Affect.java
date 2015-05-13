package compiler.instruct;

import compiler.Compteur;
import compiler.Expression;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Affect extends Instruction {

	protected String idf;
	protected Expression exp;
	
	public Affect(String idf, Expression exp) {
		this.idf = idf;
		this.exp = exp;
	}
	
	public String getSourceCode() {
		StringBuilder sb= new StringBuilder();
		sb.append(idf + " = " + exp.getSourceCode() + " ;");
		return null;
	}

	@Override
	public String getCompiledCode(Compteur i) {
		TableDesSymboles tds = TableDesSymboles.getInstance();
		StringBuilder sb = new StringBuilder();
		Symbol sym = tds.identifier(idf);
		int ad = sym.getOrigine();
		sb.append(exp.getCompiledCode(i));
		sb.append("#affectation de " + exp.getSourceCode() + " dans la variable " + idf + "\n");
		sb.append("sw $v0, " + ad + "($s7)\n");
		return sb.toString();
	}

}

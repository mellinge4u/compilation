package compiler.instruct;

import compiler.Compteur;
import compiler.Expression;
import compiler.Variable;
import compiler.exception.UndeclaredDeclarationException;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Affect extends Instruction {

	protected Variable var;
	protected Expression exp;

	public Affect(String idf, Expression exp) {
		try {
			this.var = new Variable(idf);
			this.exp = exp;
		} catch (UndeclaredDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : ??? : \"" + e.getMessage()
					+ "\" non déclarée");
		}
	}

	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(var + " = " + exp.getSourceCode() + ";\n");
		return sb.toString();
	}

	@Override
	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		if (var != null) {
			TableDesSymboles tds = TableDesSymboles.getInstance();
			Symbol sym = tds.identifier(var.getIdf(), tds.getNumeroBloc());
			int ad = sym.getOrigine();
			sb.append("#affectation de " + exp.getSourceCode() + " dans $v0\n");
			sb.append(exp.getCompiledCode(i));
			sb.append("#affectation de $v0 dans la variable " + var + "\n");
			sb.append("sw $v0, " + ad + "($s7)\n");
		}
		return sb.toString();
	}

}

package compiler.instruct;

import compiler.Compteur;
import compiler.Variable;
import compiler.tds.Symbol;
import compiler.tds.TableDesSymboles;

public class Lire extends Instruction {

	protected Variable var;
	protected TableDesSymboles tds;

	public Lire(String idf) {
		this.var = new Variable(idf);
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("lire " + var + ";\n");
		return sb.toString();
	}

	public String getCompiledCode(Compteur i) {
		Symbol s = TableDesSymboles.getInstance().identifier(var.getIdf(),
				var.getBloc());
		int adDm = s.getOrigine();
		StringBuilder sb = new StringBuilder();
		sb.append("# Lire une chaine de caractères\n"
				+ "li $v0, 5 	# $v0 <- code du read\n" + "syscall 	# lire\n"
				+ "sw $v0, " + adDm + "($s7)\n");
		return sb.toString();

	}

}

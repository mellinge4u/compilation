package compiler;

import java.util.ArrayList;

import compiler.exception.UndeclaredDeclarationException;
import compiler.instruct.Instruction;

public class Decl_const extends Declaration {

	protected ArrayList<Instruction> instructions;
	
	public Decl_const(Instruction inst) {
		instructions = new ArrayList<Instruction>();
		try {
			instructions.add(inst);
		} catch (UndeclaredDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : ??? : \""
					+ e.getMessage() + "\" non d�clar�e");
			// TODO Changer le numero de ligne
		}
	}
	
	public void addInstruction(Instruction inst) {
		try {
			instructions.add(inst);
		} catch (UndeclaredDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : ??? : \""
					+ e.getMessage() + "\" non d�clar�e");
			// TODO Changer le numero de ligne
		}
	}

	@Override
	public String getSourceCode() {
		StringBuilder sb = new StringBuilder();
		for (Instruction inst : instructions) {
			sb.append(inst.getSourceCode());
		}
		return sb.toString();
	}

	@Override
	public String getCompiledCode(Compteur i) {
		StringBuilder sb = new StringBuilder();
		for(Instruction ins : instructions){
			try {
				sb.append(ins.getCompiledCode(i));
			} catch (UndeclaredDeclarationException e) {
				System.err.println("ERREUR SEMANTIQUE : [n�ligne] : \""
						+ e.getMessage() + "\" non d�clar�e");
				// TODO Changer le numero de ligne
			}
		}
		return sb.toString();
	}

}

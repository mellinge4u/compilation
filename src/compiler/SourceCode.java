package compiler;

import compiler.oprator.arithmetic.binary.OperatorMinus;
import compiler.oprator.arithmetic.binary.OperatorPlus;
import compiler.oprator.arithmetic.unary.OperatorUnaryMinus;
import compiler.oprator.logical.binary.OperatorInferior;

public class SourceCode {

	protected String code;
	protected Expression buildCode;
	
	public SourceCode() {
		code = "7+3-5 < -12";
		Expression add = new OperatorPlus(new Constante(7), new Constante(3));
		Expression sous = new OperatorMinus(add, new Constante(5));
		Expression mDouze = new OperatorUnaryMinus(new Constante(12));
		buildCode = new OperatorInferior(sous, mDouze);
	}

	public void printSource() {
		System.out.println(code);
	}
	
	public void printSourceTree() {
		System.out.println(buildCode.getSourceCode());
	}
	
	public void printBuilt() {
		System.out.println(buildCode.getCompiledCode());
	}

	public static void main(String[] args) {
		SourceCode sc = new SourceCode();
		sc.printSource();
		sc.printSourceTree();
		sc.printBuilt();
	}
}

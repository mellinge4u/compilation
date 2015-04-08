package compiler;

public class Constante extends Expression {

	protected int cst;
	
	public Constante(int value) {
		cst = value;
	}

	public int getCst() {
		return cst;
	}

	public void setCst(int cst) {
		this.cst = cst;
	}

	@Override
	public String getDecoretedCode() {
		// TODO ecrire le bon code
		return "" + cst;
	}

}

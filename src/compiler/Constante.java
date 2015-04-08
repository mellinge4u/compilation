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

	public String genererCode(){
		StringBuilder sb = new StringBuilder();
		//sb.append("/*Code cible qui évalue la constant et la stocke dans $v0 */");
		sb.append("li $v0, "+cst+"\n");
		return sb.toString();
	}
	
}

package compiler;


public class Constante extends Expression {

	protected int cst;
	
	public Constante(String value) {
		cst = Integer.parseInt(value);
	}

	public int getCst() {
		return cst;
	}

	public void setCst(int cst) {
		this.cst = cst;
	}

	public String getSourceCode() {
		return "" + cst;
	}

	public String getCompiledCode(Compteur i){
		StringBuilder sb = new StringBuilder();
		//sb.append("/*Code cible qui évalue la constant et la stocke dans $v0 */");
		sb.append("li $v0, "+cst+"\n");
		return sb.toString();
	}
	
}

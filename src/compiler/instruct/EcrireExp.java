package compiler.instruct;

import compiler.Expression;

public class EcrireExp extends Ecrire {

	protected Expression exp;
	
	public EcrireExp(Expression exp) {
		this.exp = exp;
	}

}

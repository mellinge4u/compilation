package compiler.exception;

@SuppressWarnings("serial")
public class LexicalErrorException extends RuntimeException {

	protected int nbLigne;
	
	public LexicalErrorException(String arg0, int nbLigne) {
		super(arg0);
		this.nbLigne = nbLigne;
	}
	
	public int getNbLigne() {
		return nbLigne;
	}
}

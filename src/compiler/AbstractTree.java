package compiler;

public abstract class AbstractTree {

	public AbstractTree() {
		
	}

	public abstract String getSourceCode();

	public abstract String getCompiledCode(Compteur i);
	
}

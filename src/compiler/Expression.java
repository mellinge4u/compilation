package compiler;

public abstract class Expression extends AbstractTree {

	public Expression() {
		
	}

	public abstract String getSourceCode();

	public abstract String getCompiledCode();

}

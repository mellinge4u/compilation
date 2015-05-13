package compiler.tds;

public class Symbol {

	
	private String type;
	private enum e_visibility{publique,privee};
	private e_visibility visibility;
	
	public Symbol(String t, e_visibility v){
		type = t;
		visibility = v;
	}

	public Symbol(Symbol s){
		type = s.getType();
		visibility = s.getVisibility();
	}
	
	public e_visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(e_visibility v) {
		this.visibility = v;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	
}

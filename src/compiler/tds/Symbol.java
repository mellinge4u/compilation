package compiler.tds;

public class Symbol {

	
	private String type;
	public enum e_visibility{publique,privee};
	private e_visibility visibility;
	private int origine;
	
	public Symbol(String t, e_visibility v){
		type = t;
		visibility = v;
		origine = 0;
	}

	public Symbol(Symbol s){
		type = s.getType();
		visibility = s.getVisibility();
		origine = s.origine;
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

	public int getOrigine() {
		return origine;
	}

	public void setOrigine(int origine) {
		this.origine = origine;
	}
	
	
}

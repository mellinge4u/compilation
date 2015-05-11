package compiler.tds;

public abstract class Symbol {

	private String name;
	private String type;
	private String visibility;
	
	public Symbol(String n, String t){
		name = n;
		type = t;
		visibility = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public boolean compare(Symbol s){
		
		return name == s.getName() && type == s.getType();
		
	}
	
}

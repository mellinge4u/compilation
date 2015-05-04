package compiler;

public class Symbol {

	private String name;
	private String type;
	
	public Symbol(String n, String t){
		name = n;
		type = t;
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
	
	public boolean compare(Symbol s){
		
		return name == s.getName() && type == s.getType();
		
	}
	
}

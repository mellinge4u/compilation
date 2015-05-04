package compiler;

import java.util.ArrayList;

public class LocalDictionary {

	private ArrayList<Symbol> dl;
	
	public LocalDictionary(){
		dl = new ArrayList<>();
	}

	public ArrayList<Symbol> getDl() {
		return dl;
	}

	public void setDl(ArrayList<Symbol> dl) {
		this.dl = dl;
	}
	
	public void ajouter(Symbol s){
		dl.add(s);
	}
	
}

package compiler.tds;

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
	
//	public boolean contains(Symbol s){
//		boolean contain = false;
//		for(Symbol sy : dl){
//			if(sy.compare(s)){
//				contain = true;
//			}
//		}
//		return contain;
//	}
	
}

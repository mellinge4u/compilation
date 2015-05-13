package compiler.tds;

import java.util.HashMap;

/*
 * Table des symboles pour les classes à un seul bloc
 * On y gère que les entiers
 */

public class TableDesSymboles {

	private HashMap<String, Symbol> dictionnaire;
	private int adDmemoire;
	
	public TableDesSymboles(){
		dictionnaire = new HashMap<>();
		adDmemoire = 0;
	}

	public HashMap<String, Symbol> getDictionnaire() {
		return dictionnaire;
	}

	public void setDictionnaire(HashMap<String, Symbol> dictionnaire) {
		this.dictionnaire = dictionnaire;
	}
	
	public int getAdDmemoire() {
		return adDmemoire;
	}

	public void setAdDmemoire(int adDmemoire) {
		this.adDmemoire = adDmemoire;
	}

	public boolean existeDeja(String s){
		return dictionnaire.containsKey(s);
	}
	
	public void ajouter(String entree, Symbol s){
		if(existeDeja(entree)){
			throw new DoubleDeclarationException();
		} else {
			s.setOrigine(adDmemoire);
			adDmemoire -= 4;
			dictionnaire.put(entree, s);
		}
	}
	
	public Symbol identifier(String entree){
		Symbol s;
		if(!existeDeja(entree)){
			throw new UndeclaredDeclarationException();
		} else {
			s = new Symbol(dictionnaire.get(entree));
		}
		
		return s;
		
	}
	
}

package compiler.tds;

import java.util.HashMap;

/*
 * Table des symboles pour les classes à un seul bloc
 * On y gère que les entiers
 */

public class TableDesSymboles {

	private Symbol s;
	private HashMap<String, Symbol> dictionnaire;
	
	public TableDesSymboles(){
		dictionnaire = new HashMap<>();
	}

	public HashMap<String, Symbol> getDictionnaire() {
		return dictionnaire;
	}

	public void setDictionnaire(HashMap<String, Symbol> dictionnaire) {
		this.dictionnaire = dictionnaire;
	}
	
	public boolean existeDeja(String s){
		return dictionnaire.containsKey(s);
	}
	
	public void ajouter(String entree, Symbol s){
		if(existeDeja(entree)){
			throw new DoubleDeclarationException();
		} else {
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

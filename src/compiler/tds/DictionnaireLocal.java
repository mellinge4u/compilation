package compiler.tds;

import java.util.HashMap;

import compiler.exception.DoubleDeclarationException;
import compiler.exception.UndeclaredDeclarationException;

public class DictionnaireLocal {

	private HashMap<String, Symbol> dictionnaire;
	private int adDmemoire;
	private int numBlock;
	private int numBlockPrec; //numéro de block du prédécesseur 
	
	public DictionnaireLocal(){
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
	
	public int getNumBlock() {
		return numBlock;
	}

	public void setNumBlock(int numBlock) {
		this.numBlock = numBlock;
	}

	public int getNumBlockPrec() {
		return numBlockPrec;
	}

	public void setNumBlockPrec(int numBlockPrec) {
		this.numBlockPrec = numBlockPrec;
	}

	public boolean existeDeja(String s){
		return dictionnaire.containsKey(s);
	}
	
	public void ajouter(String entree, Symbol s){
		if(existeDeja(entree)){
			throw new DoubleDeclarationException(entree);
		} else {
			s.setOrigine(adDmemoire);
			adDmemoire -= 4;
			dictionnaire.put(entree, s);
		}
	}
	
	public Symbol identifier(String entree){
		Symbol s;
		if(!existeDeja(entree)){
			throw new UndeclaredDeclarationException(entree);
		} else {
			s = new Symbol(dictionnaire.get(entree));
		}
		
		return s;
		
	}

	public boolean contains(String e){
		return dictionnaire.containsKey(e);
	}
	
}

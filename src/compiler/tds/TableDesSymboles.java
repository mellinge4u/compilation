package compiler.tds;

import java.util.HashMap;

import compiler.exception.DoubleDeclarationException;
import compiler.exception.UndeclaredDeclarationException;

/*
 * Classe rendu singleton
 * Table des symboles pour les classes à un seul bloc
 * On y gère que les entiers
 */

public final class TableDesSymboles {

	private HashMap<String, Symbol> dictionnaire;
	private int adDmemoire;
	
	private static volatile TableDesSymboles instance = null;
	
	private TableDesSymboles(){
		dictionnaire = new HashMap<>();
		adDmemoire = 0;
	}

	 /**
     * Méthode permettant de renvoyer une instance de la classe Singleton
     * @return Retourne l'instance du singleton.
     */
    public final static TableDesSymboles getInstance() {
        //Le "Double-Checked Singleton"/"Singleton doublement vérifié" permet 
        //d'éviter un appel coûteux à synchronized, 
        //une fois que l'instanciation est faite.
        if (TableDesSymboles.instance == null) {
           // Le mot-clé synchronized sur ce bloc empêche toute instanciation
           // multiple même par différents "threads".
           // Il est TRES important.
           synchronized(TableDesSymboles.class) {
             if (TableDesSymboles.instance == null) {
               TableDesSymboles.instance = new TableDesSymboles();
             }
           }
        }
        return TableDesSymboles.instance;
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
	
}

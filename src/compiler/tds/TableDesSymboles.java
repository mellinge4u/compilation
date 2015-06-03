package compiler.tds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import compiler.exception.DoubleDeclarationException;
import compiler.exception.UndeclaredDeclarationException;

/*
 * Classe rendu singleton
 * Table des symboles pour les classes � un seul bloc
 * On y g�re que les entiers
 */

public final class TableDesSymboles {

	private Stack<DictionnaireLocal> pile;
	private ArrayList<DictionnaireLocal> liste;
	private int numeroBloc;

	private static volatile TableDesSymboles instance = null;

	private TableDesSymboles() {
		pile = new Stack<>();
		liste = new ArrayList<>();
	}

	/**
	 * M�thode permettant de renvoyer une instance de la classe Singleton
	 * 
	 * @return Retourne l'instance du singleton.
	 */
	public final static TableDesSymboles getInstance() {
		// Le "Double-Checked Singleton"/"Singleton doublement v�rifi�" permet
		// d'�viter un appel co�teux � synchronized,
		// une fois que l'instanciation est faite.
		if (TableDesSymboles.instance == null) {
			// Le mot-cl� synchronized sur ce bloc emp�che toute instanciation
			// multiple m�me par diff�rents "threads".
			// Il est TRES important.
			synchronized (TableDesSymboles.class) {
				if (TableDesSymboles.instance == null) {
					TableDesSymboles.instance = new TableDesSymboles();
				}
			}
		}
		return TableDesSymboles.instance;
	}

	public Stack<DictionnaireLocal> getPile() {
		return pile;
	}

	public void setPile(Stack<DictionnaireLocal> pile) {
		this.pile = pile;
	}

	public ArrayList<DictionnaireLocal> getListe() {
		return liste;
	}

	public void setListe(ArrayList<DictionnaireLocal> liste) {
		this.liste = liste;
	}

	public int getNumeroBloc() {
		return numeroBloc;
	}

	public void setNumeroBloc(int numeroBloc) {
		this.numeroBloc = numeroBloc;
	}

	/**
	 * fonctions propres � la gestions des blocs
	 */
	public void entreeBloc() {
		numeroBloc++;
		DictionnaireLocal dl = new DictionnaireLocal();
		pile.push(dl);
		liste.add(dl);
	}

	public void ajouter(String entree, Symbol s) {
		DictionnaireLocal DLcourant = pile.firstElement();
		DLcourant.ajouter(entree, s);
	}

	public void sortieBloc() {
		pile.pop();
	}

	public Symbol identifier(String entree) {
		Symbol ns = null;
		try {
			for (int i = 0; i < pile.size(); i++) {
				if (pile.get(i).contains(entree)) {
					ns = pile.get(i).getDictionnaire().get(entree);
					break;
				}
			}
			return ns;
		} catch (UndeclaredDeclarationException e) {

		}
		return ns;
	}
}

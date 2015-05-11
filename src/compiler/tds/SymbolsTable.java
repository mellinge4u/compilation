package compiler.tds;

import java.util.ArrayList;
import java.util.Stack;

public class SymbolsTable {

	private ArrayList<LocalDictionary> liste;
	private Stack<LocalDictionary> stack;
	private int numBlock;
	
	public SymbolsTable(){
		liste = new ArrayList<>();
		stack = new Stack<>();
		numBlock = -1;
	}

	public ArrayList<LocalDictionary> getListe() {
		return liste;
	}

	public void setListe(ArrayList<LocalDictionary> liste) {
		this.liste = liste;
	}

	public Stack<LocalDictionary> getStack() {
		return stack;
	}

	public void setStack(Stack<LocalDictionary> stack) {
		this.stack = stack;
	}

	public int getNumBlock() {
		return numBlock;
	}

	public void setNumBlock(int numBlock) {
		this.numBlock = numBlock;
	}
	
	public void entreeBloc(){
		numBlock++;
		LocalDictionary ld = new LocalDictionary();
		stack.push(ld);
		liste.add(ld);
	}
	
	public void ajouter(Symbol s){
		LocalDictionary currentLD = stack.peek(); // on récupère le premier de la pile
		currentLD.ajouter(s);
	}
	
	public void sortirBloc(){
		stack.pop();
	}
	
	public String identifier(Symbol s){
		LocalDictionary  currentLD = stack.peek();
		String name = "empty";
		if(currentLD.contains(s)){
			name = s.getName();
		} else {
			for(int i = stack.size()-2; i >= 0;i--){
				currentLD = stack.get(i);
				if(currentLD.contains(s)){
					name = s.getName();
				}
			}
		}
		return name;
		// rajouter la gestion des exception : UndeclaredDeclarationException
	}
	
}

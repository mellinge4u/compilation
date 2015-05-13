package compiler;

public final class Data {

	/*
	 * Class Data data qui permet d'ajoutzer à la fin du fichier mips le
	 * .data pour la permettre une bonne utilisation de la classe EcrireChaine
	 */
	
	private StringBuilder sb;
	private static volatile Data instance = null;
	
	private Data(){
		sb = new StringBuilder();
		sb.append(".data\n");
	}
	
	 public final static Data getInstance() {
         //Le "Double-Checked Data"/"Data doublement vérifié" permet 
         //d'éviter un appel coûteux à synchronized, 
         //une fois que l'instanciation est faite.
         if (Data.instance == null) {
            // Le mot-clé synchronized sur ce bloc empêche toute instanciation
            // multiple même par différents "threads".
            // Il est TRES important.
            synchronized(Data.class) {
              if (Data.instance == null) {
                Data.instance = new Data();
              }
            }
         }
         return Data.instance;
     }
	
	 public String getData(){
		 return sb.toString();
	 }
	 
	 public void append(String s){
		 sb.append(s);
	 }
	 
}

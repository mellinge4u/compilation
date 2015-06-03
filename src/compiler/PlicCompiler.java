package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import compiler.exception.DoubleDeclarationException;
import compiler.exception.LexicalErrorException;
import compiler.exception.UndeclaredDeclarationException;
import compiler.tools.AnalyseurLexical;
import compiler.tools.AnalyseurSyntaxique;

public class PlicCompiler {

	public static String readFile(String fileName) {
		StringBuilder code = new StringBuilder();
		try {
			InputStream f = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(f);
			BufferedReader d = new BufferedReader(isr);
			String line;
			line = d.readLine();
			while (line != null) {
				code.append(line + '\n');
				line = d.readLine();
			}
			d.close();
		} catch (FileNotFoundException e) {
			System.err.println("ERREUR : " + e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("ERREUR : Lecture du fichier");
			System.exit(1);
		}
		return code.toString();
	}

	public static AbstractTree compile(String code) {
		StringReader sr = new StringReader(code);
		AnalyseurLexical al = new AnalyseurLexical(sr);
		AnalyseurSyntaxique as = new AnalyseurSyntaxique(al);

		AbstractTree tree = null;
		Classe classe = null;
		try {
			classe = (Classe) as.parse().value;
		} catch (LexicalErrorException e) {
			System.err.println("ERREUR LEXICALE : " + e.getNbLigne() + " : \""
					+ e.getMessage() + "\" non identifiée");
			System.exit(1);
		} catch (DoubleDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \""
					+ e.getMessage() + "\" deja déclarée");
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur : génération de l'arbre abstrait");
			System.exit(1);
		}
		return classe;
	}

	public static void writeFile(AbstractTree tree, String fileName) {
		try {
			String finalCode = tree.getCompiledCode(new Compteur(0));
			File file = new File(fileName);
			file.createNewFile();
			FileOutputStream fileFlux = new FileOutputStream(file);
			FileWriter fw = new FileWriter(file);
			fw.write(finalCode);
			fileFlux.close();
			fw.close();
		} catch (UndeclaredDeclarationException e) {
			System.err.println("ERREUR SEMANTIQUE : [n°ligne] : \""
					+ e.getMessage() + "\" non déclarée");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String fileIn = null;
		String fileOut = null;
		if (args.length == 2) {
			fileIn = args[0];
			fileOut = args[1];
		} else {
			System.out
					.println("Erreur : Il n'y a pas le bon nombre d'arguments");
			System.out.println("ex : plic source.plic destination.asm");
			System.exit(-1);
		}
		String code = readFile(fileIn);
		AbstractTree tree = compile(code);
		tree.getSourceCode();
		writeFile(tree, fileOut);
		System.out.println("COMPILATION OK");
	}
}

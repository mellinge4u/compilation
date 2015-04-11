package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import compiler.tools.AnalyseurLexical;
import compiler.tools.AnalyseurSyntaxique;

public class PlicCompiler {

	public static String readFile(String fileName) {
		StringBuilder code = new StringBuilder();
		try {
			InputStream f = new FileInputStream(fileName);
			InputStreamReader isr = new InputStreamReader(f);
			BufferedReader d = new BufferedReader(isr);
			code.append(d.readLine());
			code.append("\n");
			d.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur : Lecture du fichier");
			System.exit(1);
		}
		return code.toString();
	}

	public static AbstractTree compile(String code) {
		StringReader sr = new StringReader(code);
		AnalyseurLexical al = new AnalyseurLexical(sr);
		AnalyseurSyntaxique as = new AnalyseurSyntaxique(al);

		AbstractTree tree = null;

		try {
			tree = (AbstractTree) as.parse().value;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur : génération de l'arbre abstrait");
			System.exit(1);
		}

		return tree;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		String fileIn = "exp.plic";
		String fileOut = "exp.ams";
		if (args.length >= 2) {
			fileIn = args[1];
			fileOut = args[2];
		}
		System.out.println("Début de la compilation");
		System.out.println("Lecture du fichier source");
		String code = readFile(fileIn);
		System.out.println(code);
		System.out.println("Traduction en mips");
		AbstractTree tree = compile(code);
		System.out.println("Ecriture du fichier destination");
		System.out.println(tree.getSourceCode());
		writeFile(tree, fileOut);
		// System.out.println(tree.getCompiledCode());
	}
}

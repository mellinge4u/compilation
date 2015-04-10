package compiler;

import java.io.BufferedReader;
import java.io.FileInputStream;
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

	public static void main(String[] args) {
		String fileIn = "exp.plic";
		String fileOut = "exp.mips";
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
		System.out.println(tree.getCompiledCode());
	}
}

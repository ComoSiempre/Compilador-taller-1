package tallerN1_compiladores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import jflex.Main;



public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path="C:/Users/JonathanDavis/workspace/tallerN1_compiladores/src/tallerN1_compiladores/Lexer.flex";
		PrintWriter writer=new PrintWriter(new File ("resultados.txt"));
		//Scanner.generarLexer(path);
		Scanner.lecturaEjemplosBuenos(writer);
		Scanner.lecturaEjemplosMalos(writer);
	}
	//para comentar lineas: cntrl+shift+C
	//..;...;...;...;
	
}


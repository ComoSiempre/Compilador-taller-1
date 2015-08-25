package tallerN1_compiladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.PrintWriter;

public class Scanner {
	
	public static void generarLexer(String path){
		File file=new File(path);
		jflex.Main.generate(file);
		
	}
	
	
	
	public static void probarLexerFile(String nombreArch,PrintWriter writer) throws IOException{
		Reader reader = new BufferedReader(new FileReader(nombreArch));
		Lexer lexer = new Lexer (reader);
	    String resultado="";
	    System.out.println("RESULTADOS DEL ARCHIVO: "+nombreArch);
	    writer.println("RESULTADOS DEL ARCHIVO: "+nombreArch);
	    while (true){
	        Token token =lexer.yylex();
	        if (token == null){
	            resultado=resultado+"FIN DE ARCHIVO";
	            System.out.println(resultado);
	            resultado=resultado+"------------------------------";
	            System.out.println("------------------------------");
	            writer.println("FIN DE ARCHIVO");
	            writer.println("------------------------------------");
	            writer.println("");
	            return;
	        }
	        switch (token){
	            case ERROR:
	            	resultado=resultado+ "linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";\n RESPUESTA: Error, simbolo no reconocido: '"+lexer.lexeme+"'\n";
	                writer.println("linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";"); 
	                writer.println("RESPUESTA: Error, simbolo no reconocido: '"+lexer.lexeme);
	            	break;
	            case ID: case NUM:
	            	resultado=resultado+ "linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";\n <TOKEN "+token+": '" + lexer.lexeme + "'> \n";
	            	writer.println("linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";");
	            	writer.println("<TOKEN "+token+": '" + lexer.lexeme + "'>");
	            	break;
	            case IF: case VOID: case INT: case ELSE: case RETURN:
	            case WHILE: case DO:
	            	resultado=resultado+ "linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";\n <palabra clave "+token+": '"+lexer.lexeme+"'>\n";
	            	writer.println("linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";");
	            	writer.println("<palabra clave "+token+": '"+lexer.lexeme+"'>");
	            	break;
	            default:
	            	resultado=resultado+"linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";\n <Simbolo especial "+token+": '" +lexer.lexeme+"'>\n";
	            	writer.println("linea:"+lexer.fila+", "+"Columna: "+lexer.columna+";");
	            	writer.println("<Simbolo especial "+token+": '" +lexer.lexeme+"'>");
	            	break;
	        }
	    }
	    	    
	}
	
	public static void lecturaEjemplosBuenos(PrintWriter writer) throws IOException{
		probarLexerFile("ejemplo1.txt",writer);
		probarLexerFile("ejemplo2.txt",writer);
		probarLexerFile("ejemplo3.txt",writer);
		probarLexerFile("ejemplo4.txt",writer);
		probarLexerFile("ejemplo5.txt",writer);
		
		
	}
	public static void lecturaEjemplosMalos(PrintWriter writer) throws IOException{
		probarLexerFile("ejemplo6.txt",writer);
		probarLexerFile("ejemplo7.txt",writer);
		probarLexerFile("ejemplo8.txt",writer);
		probarLexerFile("ejemplo9.txt",writer);
		probarLexerFile("ejemplo10.txt",writer);
	}


}

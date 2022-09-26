package lym.mundoParser;

import java.util.*;

import lym.languages.javita.Javita;
//import language definition

public class MundoParsers {
	
	// Nombres de los Parsers
	private  ArrayList  <String> parsers  = new ArrayList <String> (); 
	
	// Parser que se esta usando
	private int currentParser;
	
	static Javita javita;
	
	
	public  MundoParsers () {
  	
		// Agreguen al final de esta lista los nombres del nuevo parser
		
	    //parsers.add("PARSER NAME");
	    
		parsers.add("Javita");
		javita = getJavita();
	    currentParser =  0;
	}
	
	/*
	public ParserNAME getParserNAME(){
		return new ParserCAML(System.in);
	}
	*/
	
	public Javita getJavita(){
		return new Javita(System.in);
	}
	
	
	public String getStringCurrentParser(){
		return parsers.get(currentParser);
	}
	
	public int getCurrentParser() {
		return currentParser;
	}
	
	public void setCurrentParser(int p) {
		currentParser = p;
	}
	
	public String getParser(int i) {
		return parsers.get(i);
	}
	
	public int sizeParsers() {
		return parsers.size();
	}
	
	public String  procesarCadena(String texto) {
		String resp = "";
		/*
		if(parsers.get(currentParser).equals("ParserNAME")){
			ParserNAME parserNAME = getParserNAME();
			parserNAME.ReInit(new java.io.StringReader(texto));
			try {
		    	parserNAME.initialElement(); 
		    	resp = new String("OK    \n");
		    }catch (Exception e) {
		        resp = new String ("Error de Sintaxis: "+e.getMessage());
		     } catch (Error e) {
		    	 resp = new String ("Error Lexico: "+e.getMessage());
				}
		}
		*/
		
		if(parsers.get(currentParser).equals("Javita")) {
			/*Javita javita = getJavita();*/
			javita.ReInit(new java.io.StringReader(texto));
			try {
				javita.program();
				resp = new String("OK\n");
			} catch (Exception e) {
				resp = new String("Error de Sintaxis: "+e.getMessage());
			} catch (Error e) {
				resp = new String("Error Lexico: "+e.getMessage());
			}
		}
		return "\n SISTEMA " + parsers.get(currentParser) + ": " + resp + "\n";
	}

}
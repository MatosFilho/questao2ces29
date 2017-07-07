package source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerableClass {
	private static String buffer;
	private static String texto;
	
	/*
	public static String pegaDoBuffer () {
		Scanner console = new Scanner (System.in);
		String buff = console.nextLine();
		console.close();
		return buff;
	}
	*/
	
	public static void setTexto (String txt) {
		texto = txt;
	}
	
	public static void setBuffer (String op) {
		buffer = op;
	}
	
	public static String vulnerableMethod(String FILENAME){
		boolean loop = true;
		String msg = "";
		
		Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
		Matcher matcher = pattern.matcher (FILENAME);
		if(matcher.find()) {
			msg = "Nome de arquivo não atende aos padrões.";
			loop = false;
		}
		
		while (loop) {	    
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo, EXIT para sair>? ");
			
		    //String opr= pegaDoBuffer ();
		    String opr = buffer;
		    
		    if (opr.equals("R")){
				try {
					String sCurrentLine;
					BufferedReader br = new BufferedReader(new FileReader(FILENAME));
					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}
					msg = "Arquivo impresso na tela com sucesso.";
					br.close();
					loop = false;
				} catch (IOException e) { e.printStackTrace(); } 
			}
			
			else if (opr.equals("W")){
				  try {
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
				    linha = texto;
				    buffWrite.append(linha + "\n");
				    msg = "Escrita de arquivo realizada com sucesso.";
				    buffWrite.close();
				    loop = false;
				} catch (IOException e) { e.printStackTrace(); } 
			}
			else if (opr.equals("EXIT")) {
				System.out.println("Fim da manipulacao do arquivo.");
				msg = "Fim da manipulacao do arquivo.";
				loop = false;
			}
			else {
				System.out.println("Comando invalido. Tente novamente");
				msg = "Comando invalido. Tente novamente.";
				loop = false;
			}
		}
		return msg;
	}
}

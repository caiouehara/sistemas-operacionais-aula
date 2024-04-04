import java.io.*;

public class Exercicio2{
	public static void main(String[] args){
		//declarando as variáveis
		ProcessBuilder pb;
		Process proc;

		pb = new ProcessBuilder("ls", "-al").inheritIO();
		try{
			proc = pb.start(); //inicia o processo
			proc.waitFor();
			System.out.println("Saída do processo filho: " + proc.exitValue());
		} catch (IOException ioe){
			System.out.println(ioe);
		} catch (InterruptedException ie){
			System.out.println(ie);
		}

	}
}

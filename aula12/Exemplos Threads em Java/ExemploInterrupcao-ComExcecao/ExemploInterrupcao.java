/*
 * @author Clever R. G. de Farias
 */
import java.util.Scanner;

public class ExemploInterrupcao {
    
	// metodo main
    public static void main(String[] args) {
		// declaracao de variaveis
        Scanner sc;		// leitura da interrupcao da thread
		Thread thrd;	// thread a ser interrompida
		
		// verificacao argumentos programa
        if (args.length != 1) {
	  		System.err.println("Nro de parametros deve ser 1");
	  		System.exit(0);
		}
		
		// inicializacao das variaveis
		sc = new Scanner(System.in);
 	    thrd = new Thread(new InterruptibleThread(Integer.parseInt(args[0])));
		
		//dispara a execucao da thread
		thrd.start();
		
		// le comando para interrupcao
        System.out.println("Tecle <Enter> para interromper");
        sc.nextLine();             
 
		try {
            thrd.interrupt();
		} catch (SecurityException se) {
            System.out.println("Nao foi possivel interromper");
        }
        
		// espera pelo termino da thread interrompida
		try {
             thrd.join();
        } catch (InterruptedException ie) {
            System.out.println("Problema com a uniao das threads");
        }
		
        System.out.println("Thread principal (main) encerrando...");
    }
}

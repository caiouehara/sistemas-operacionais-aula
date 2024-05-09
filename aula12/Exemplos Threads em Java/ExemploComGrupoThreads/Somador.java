/**
 *
 * @author Clever R. G. de Farias
 */
import java.util.Random;

public class Somador implements Runnable{
    private int limiteSomatoria; 	// limite da somatoria
    private Soma somaLimite;		// soma de zero ate limite
    
    // construtor da Thread
    public Somador(int limite, Soma value) {
    
		limiteSomatoria = limite;
        somaLimite = value;
    }

	// comportamento da thread
    public void run() {
		// declaracao de variaveis
		Random generator;	// gerador de nro aleatorio
        int soma;			// soma de zero ate limite
		
		// inicializacao das variaveis
		generator = new Random();
		soma = 0;
		
		// espera tempo aleatorio: 0 a 5 segundos
		try{
			Thread.sleep(1000*generator.nextInt(6));
		} catch (InterruptedException ie){
			System.out.println("Thread foi interrompida: " + ie);
			System.exit(-1); // encerra comportamento com erro
		}
		
		// calcula e armazena a soma ate o limite
        for (int i = 0; i <= limiteSomatoria; i++)
        	soma+= i;
		
		// armazena o valor da somatoria
        somaLimite.setSoma(soma);
    }    
}

/**
 *
 * @author Clever R. G. de Farias
 */
public class Somador implements Runnable{
    private int limiteSomatoria; 	// limite da somatoria
    private Soma somaLimite;		// soma de zero ate limite
    
    // construtor da Thread
    public Somador(int limite, Soma valorInicial) {
    
		limiteSomatoria = limite;
        somaLimite = valorInicial;
    }

	// Comportamento da Thread
    public void run() {
		// declaracao variavel
        int soma = 0;

		// calcula e armazena a soma ate o limite
        for (int i = 0; i <= limiteSomatoria; i++)
        	soma+= i;
		
		// armazena o valor da somatoria
        somaLimite.setSoma(soma);
    }    
}

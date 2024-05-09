/**
 *
 * @author Clever R. G. de Farias
 */
public class SomaNroPositivo {

	// metodo main
    public static void main(String[] args) {
        // declaracao variaveis
		Thread thrd; 		// thread que irá realizar a soma de zero até limite
		Soma somaLimite; 	// armazena a soma que será calculada pela Thread Somador
		int limite;			// armazena o limite da soma
		
		// verifica nros de argumentos passados para o programa
		if (args.length != 1) {
			System.err.println("Nro de parametros deve ser 1");
			System.exit(0);
		}

		// extracao do limite
		limite = Integer.parseInt(args[0]);
		
		// instanciacao das variaveis
		somaLimite = new Soma();
		thrd = new Thread(new Somador(limite, somaLimite));
		
		//dispara a execucao da thread
		thrd.start();
		try {
            thrd.join();	// espera pelo termino da thread Somador
		} catch (InterruptedException ie) { 
        }
		
		// escreve resultado da soma de zero até limite
		System.out.println("Soma de 0 ate " + limite + " = " + somaLimite.getSoma());
    }        
}

/**
 * @author Clever R. G. de Farias
 */
public class SomaNroPositivo {

	// metodo main
    public static void main(String[] args) {
        // declaracao variaveis
		ThreadGroup grupo;		// grupo de threads
		Thread thrd; 			// thread que irá realizar a soma de zero até limite
		Soma[] arraySomaLimite;	// array que ira armazenar a soma ate o limite que será calculada pela Thread Somador
		int nroThreadsAtivas;	// armazena o nro de threads ativas
		int i;					// indice array
		
		// verifica nros de argumentos passados para o programa
		if (args.length < 1) {
			System.err.println("Nro de parametros deve ser maior ou igual a 1");
			System.exit(0);
		}
		
		// inicializacao das variaveis
		grupo = new ThreadGroup("Somador");
		arraySomaLimite = new Soma[args.length];

		// cria uma thread para realizar a soma ate um limite
        for (i = 0; i < args.length; i++){
			// cria nova soma para armazenar o resultado
			arraySomaLimite[i] = new Soma();
			
			// cria nova thread para realizar a somatoria e associa ao grupo de threads
            thrd = new Thread(grupo, new Somador(Integer.parseInt(args[i]), arraySomaLimite[i]));
			
			// dispara a execucao da thread que realiza a somatoria
            thrd.start();
        }
        
		while (grupo.activeCount() > 0){
            System.out.println("Nro threads ativas = " + grupo.activeCount());
            try{
                Thread.sleep(500);	// espera 500 ms
            } catch (InterruptedException ie){
                System.out.println("Erro: " + ie);
            }
        }
		
		// escreve resultado das somas
        System.out.println("Calculo encerrado:");
		for (i = 0; i < args.length; i++){
			System.out.println(" - soma de 0 ate " + args[i] + " = " + arraySomaLimite[i].getSoma());
		}
    }        
}

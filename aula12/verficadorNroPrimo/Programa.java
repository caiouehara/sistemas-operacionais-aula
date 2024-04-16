public class Programa {
    public static void main(String[] args) {
        // declaracao variaveis
		ThreadGroup grupo;		// grupo de threads
		Thread thrd; 			// thread que irá realizar a soma de zero até limite

		// verifica nros de argumentos passados para o programa
		if(args.length < 0){
			System.out.println("Argumento inválido");
		}

		// inicializacao das variaveis
		grupo = new ThreadGroup("PrimeChecker");

		//execucao das Threads
		for(int i=0; i< args.length; i++){
			thrd = new Thread(grupo, new PrimeCheckerThread(Integer.parseInt(args[i])));
			thrd.start();

			/*
			try {
				thrd.join();	// espera pelo termino da thread
						
				// gets the ID of the current thread 
				System.out.println(String.format("[%s] Comportamento encerrado", thrd.threadId()));
			} catch (InterruptedException ie) { 
				System.out.println("Erro: " + ie);
			}
			*/
		}
		
		while (grupo.activeCount() > 0){
            System.out.println("Nro threads ativas = " + grupo.activeCount());
            try{
                Thread.sleep(500);	// espera 500 ms
            } catch (InterruptedException ie){
                System.out.println("Erro: " + ie);
            }
        }
		

    }        
}

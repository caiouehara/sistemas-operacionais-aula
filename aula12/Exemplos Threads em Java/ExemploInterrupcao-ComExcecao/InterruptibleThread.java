/**
 *
 * @author Clever R. G. de Farias
 */
public class InterruptibleThread extends Thread{
    // declaracao variavel
    int sleepTime;	// tempo em que a thread ira realizar espera cronometrada
    
	// construtor da Thread
    public InterruptibleThread(int time) {
        sleepTime = time;
    }
    
	// comportamento da Thread
    public void run(){
        while (true){	// laco infinito
			// realiza tarefa
			for (int i = 0; i < 1000; i++);		// espera ocupada - simula realizacao tarefa	
			
			// espera cronometrada - verifica se ha interrupcao		
            try{
              sleep(sleepTime);		// espera cronometrada 
            } catch (InterruptedException ie){
                System.out.println("Thread foi interrompida: " + ie);
                break; // sai do laco infinito
            } 
        }	// fim while
    } 	// fim run
}	// fim class

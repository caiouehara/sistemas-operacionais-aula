/**
 *
 * @author Clever R. G. de Farias
 */
public class InterruptibleThread extends Thread{
    // declaracao variavel
    int busyWait;	// contador para espera ocupada
    
	// construtor da Thread
    public InterruptibleThread(int value) {
        busyWait = value;
    }
    
	// comportamento da Thread
    public void run(){
        while (true){	// laco infinito
			for (int i = 0; i < busyWait; i++);		// espera ocupada - simula realizacao tarefa
			
			// verifica se ha sinalizacao indicando interrupcao
	        if (Thread.currentThread().isInterrupted()){
	            System.out.println("Thread foi interrompida!!!");
	            break; // sai do laco infinito
	        }
        } 	// fim while
    } 	// fim run
}	// fim class

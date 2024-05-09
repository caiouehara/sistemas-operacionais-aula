public class Consumer implements Runnable {
    //declaração de atributos
    private BufferLimitado<String> buffer; //buffer limitado
    private int qtde; //quantidade de elementos a serem inseridos

    public Consumer(BufferLimitado<String> buffer, int qtde){
        this.buffer = buffer;
        this.qtde = qtde;
    }

    public void run(){
        for(int i = 0; i < qtde; i++){
            buffer.remove();
        }
    }
}

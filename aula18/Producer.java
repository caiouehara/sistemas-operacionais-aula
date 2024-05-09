public class Producer implements Runnable {
    //declaração de atributos
    private BufferLimitado<String> buffer; //buffer limitado
    private String[] stringArray; //armazena os itens a serem inseridos
    private int start; //posicao inicial do array
    private int qtde; //quantidade de elementos a serem inseridos

    public Producer(BufferLimitado<String> buffer, String[] stringArray, int start, int qtde){
        this.buffer = buffer;
        this.stringArray = stringArray;
        this.start = start;
        this.qtde = qtde;
    }

    public void run(){
        for(int i = 0; i < qtde; i++){
            buffer.insert(stringArray[start+i]);
        }
    }
}

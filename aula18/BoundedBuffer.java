/*
 * BoundedBuffer.java
 * 
 */
 
public class BoundedBuffer<E> implements Buffer<E>{
    
	private int count;			// número de itens no buffer
    private int in;             // aponta para próxima posição livre
    private int out;            // aponta próxima posição cheia
    private E[] buffer;    		// buffer
    
    public BoundedBuffer(int size){
		count = 0;
        in = 0;
        out = 0;
        buffer = (E[]) new Object[size];
    }

    public void insert(E item){
		while (count == buffer.length); // não faz nada -- nenhum buffer livre 
		count++;
        buffer[in] = item;
        in = (in + 1) % buffer.length;
    }
    
    public E remove(){
        E item;
        
		while (count == 0); // não faz nada -- nada para consumir 
		count--;
        item = buffer[out];
        out = (out + 1) % buffer.length;
        return item;
    }
}
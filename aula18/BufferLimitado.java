/*
 * BufferLimitado.java
 * 
 */

import java.util.concurrent.Semaphore;

public class BufferLimitado<E> implements Buffer<E>{
   private int in;             // aponta para próxima posição livre
   private int out;            // aponta próxima posição cheia
   private E[] buffer;    		// buffer

   private Semaphore mutex, //semáforo binário - exclusão mútua
                     empty, //semáforo contador - nros de espaços vazios no buffer
                     full; //semáforo contador - nro de itens no buffer

   @SuppressWarnings("unchecked")
   public BufferLimitado(int size){
      in = 0;
      out = 0;
      buffer = (E[]) new Object[size];

      mutex = new Semaphore(1);
      empty = new Semaphore(size);
      full = new Semaphore(0);
   }

   public void insert(E item){
      try{
         
         empty.acquire(); //decrementando a qtde de espaços vazios no buffer
         mutex.acquire(); //entrada na região crítica

         //insert item
         buffer[in] = item;
         in = (in + 1) % buffer.length;
         System.out.println("Elemento " + item + " foi inserido no buffer.");

         mutex.release(); //saída da região crítica
         full.release();

      } catch (InterruptedException e){
         System.out.println("Erro de inserção no buffer: " + item);
      }
   }
    
   public E remove(){
      E item = null;

      try{
         //entrada na região crítica
         full.acquire();
         mutex.acquire();

         //remove item
         item = buffer[out];
         out = (out + 1) % buffer.length;
         System.out.println("Elemento " + item + " foi removido do buffer.");

         //saída da região crítica
         mutex.release();
         empty.release();

      } catch (InterruptedException e){
         System.out.println("Erro de remoção no buffer");
      }

      //passing item to consume
      return item;
   }
}
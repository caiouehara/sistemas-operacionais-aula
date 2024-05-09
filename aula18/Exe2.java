public class Exe2 {
    public static void main(String[] args){
        // declaração de variáveis
        Thread thrP, thrC; //threads produtor e consumidor
        BufferLimitado<String> buffer;
        int numThreadProd, numThreadCons; //quantidade de threads produtor e consumidor
        int i; // indiceArray

        //inicilizar o buffer
        buffer = new BufferLimitado<String>(3);

        //inicilizar threads consumidores
        numThreadCons = 1;
        for (i=0; i < numThreadCons; i++){
            thrC = new Thread(new Consumer(buffer, (args.length/numThreadCons)));
            thrC.start();
        }

        //inicilizar threads consumidores
        numThreadProd = 1;
        for (i=0; i < numThreadProd; i++){
            thrP = new Thread(new Producer(buffer, args, i * (args.length/numThreadProd), (args.length/numThreadProd)));
            thrP.start();
        }

    }
}

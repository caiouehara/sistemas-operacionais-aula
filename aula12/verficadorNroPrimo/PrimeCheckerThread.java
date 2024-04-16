public class PrimeCheckerThread implements Runnable{
    private int primeCandidate; 	
    
    // construtor da Thread
    public PrimeCheckerThread(int candidate) {
		primeCandidate = candidate;
    }

	private boolean isPrime(int n){
		if (primeCandidate == 2){
			return true;
		} else {
			if((primeCandidate % 2) == 0)
				return false;
			else {
				for (int i = 3; i*i <= primeCandidate; i+=2){
					if ((primeCandidate % i )==0)
						return false;
				}
			}
		}
		return true;
	}

	// comportamento da thread
    public void run() {
		if(isPrime(primeCandidate)){
			System.out.println(primeCandidate + " é primo");
		} else {
			System.out.println(primeCandidate + " não é primo");
		}
    }    
}

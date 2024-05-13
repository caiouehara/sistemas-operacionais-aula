import java.io.IOException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
		String userInput;
		Scanner scanner = new Scanner(System.in);

		while(true){
			try {
				System.out.print("> ");
				userInput = scanner.nextLine();

				if(userInput.equals("exit")){
					break;
				}

				ProcessBuilder processBuilder = new ProcessBuilder(userInput.split(" ")).inheritIO();
				Process process = processBuilder.start();
				process.waitFor();
			} catch (IOException ioEx){
				System.out.println("Comando inválido");
			} catch (InterruptedException interrEx){
				System.out.println("Ocorreu um erro");
			}
		}

		scanner.close();
    }        
}

import java.io.*;
import java.lang.ProcessBuilder.Redirect;
import java.util.*;

public class PipeShell {
    public static void main(String[] args) {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("> ");
                userInput = scanner.nextLine();
                if (userInput.equals("exit"))
                    break;
                
                String[] pipedCommands = userInput.split(" [|] ");

                if(pipedCommands.length > 1) {
                    ArrayList<ProcessBuilder> builders = new ArrayList<ProcessBuilder>();
                    for (String command : pipedCommands) {
                        builders.add(new ProcessBuilder(command.split(" ")));
                    }
                    
                    builders.get(builders.size() - 1).redirectOutput(Redirect.INHERIT);
    
                    List<Process> processes = ProcessBuilder.startPipeline(builders);
                    Process last = processes.get(processes.size()-1);
                    last.waitFor();
                } else {
                    ProcessBuilder processBuilder = new ProcessBuilder(userInput.split(" ")).inheritIO();
                    Process process = processBuilder.start();
                    process.waitFor();
                }
                
            } catch (IOException ioEx) {
                System.out.println("Comando invalido");
            } catch (InterruptedException e) {
                System.out.println("Ocorreu um erro");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}

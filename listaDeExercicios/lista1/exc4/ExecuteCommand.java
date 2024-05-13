public class ExecuteCommand implements Runnable {
    Process process;

    public void run(){
        process = Runtime.getRuntime()
            .exec(String.format("cmd.exe /c dir %s", homeDirectory));
    }    
}
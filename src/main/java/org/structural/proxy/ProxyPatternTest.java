package src.main.java.org.structural.proxy;

public class ProxyPatternTest {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("Test",
                "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}
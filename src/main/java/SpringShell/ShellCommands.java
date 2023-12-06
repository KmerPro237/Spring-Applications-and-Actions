package SpringShell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.logging.Logger;

import static java.lang.String.format;

@ShellComponent
@SpringBootApplication
public class ShellCommands {

    Logger log = Logger.getLogger(ShellCommands.class.getName());

    @ShellMethod(key = "hello", value = "Says hello")
    public String helloWorld(
            @ShellOption(defaultValue = "spring") String arg
    ) {
        return "Hello world " + arg;
    }

    @ShellMethod (key ="connect-remote", prefix = "-", value="connect to remote server")
    public String sshConnect(@ShellOption(value = "-s") String remoteServer) {
        return "Connecting to remote server..." + remoteServer;
    }

    @ShellMethod (value = "nslookup")
    public String nslookup(@ShellOption(defaultValue = "default-server") String remoteServer) {
        return "nslookup " + remoteServer;
    }

    @ShellMethod (value = "ssh-login")
    public void sshLogin(@ShellOption(value = "-u") boolean rememberMe){
        log.info(format("Remember me: %s", rememberMe));
    }

    public static void main(String[] args) {
        SpringApplication.run(ShellCommands.class, args);
    }
}

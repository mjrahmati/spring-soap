package ir.piana.edu.soap.client;

import ir.piana.edu.soap.dto.Channel;
import ir.piana.edu.soap.dto.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.UUID;

@SpringBootApplication(scanBasePackages = {"ir.piana.edu.soap"})
public class MainApp {
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Autowired
    private SoapClientService soapClientService;


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        LoginResult loginResult = soapClientService.login(
                "mjrahmati",
                "123456",
                Channel.WEB,
                1);
        soapClientService.logout(UUID.randomUUID().toString());
        System.out.println("The login and logout request was successful.");
    }
}

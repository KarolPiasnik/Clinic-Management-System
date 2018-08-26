import com.mongodb.*;
import entities.Patient;
import enums.SexEnum;
import gui.PatientAdminPanel;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.PatientRepository;

import javax.swing.*;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private PatientRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Patient("Alice", "Smith", "11111111111", 21, SexEnum.FEMALE));
        repository.save(new Patient("Bob", "Smith", "11111111111", 21, SexEnum.MALE));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Patient patient : repository.findAll()) {
            System.out.println(patient);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Patient patient : repository.findByLastName("Smith")) {
            System.out.println(patient);
        }

        PatientAdminPanel app = new PatientAdminPanel();
        JFrame frame = new JFrame("App");
        frame.setContentPane(app.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.pack();

    }
}

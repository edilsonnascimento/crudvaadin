package br.edu.utfpr.crudvaadin;

import br.edu.utfpr.crudvaadin.data.model.Cliente;
import br.edu.utfpr.crudvaadin.data.service.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.helpers.LaunchUtil;
import com.vaadin.flow.component.dependency.NpmPackage;

import java.time.LocalDate;
import java.time.Month;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@NpmPackage(value = "lumo-css-framework", version = "^4.0.10")
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
    }

    @Bean
    public CommandLineRunner demo(ClienteRepository repository) {
        return (args) -> {
            repository.save(new Cliente("Jack", "Bauer", LocalDate.of(1977, Month.MARCH, 3), "jbauer@yahoo.com.br"));
            repository.save(new Cliente("Chloe", "O'Brian", LocalDate.of(1984, Month.JULY, 11), "chloe1984@terra.com.br"));
        };
    }


}

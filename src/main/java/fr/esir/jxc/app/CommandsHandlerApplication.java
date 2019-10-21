package fr.esir.jxc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "fr.esir.jxc")
public class CommandsHandlerApplication {
    public static void main(String... args) {
        SpringApplication.run(CommandsHandlerApplication.class, args);
    }
}


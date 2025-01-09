package com.CFCM.ConsultaLiteral;

import com.CFCM.ConsultaLiteral.Principal.Principal;
import com.CFCM.ConsultaLiteral.Repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaLiteralApplication implements CommandLineRunner {
    @Autowired
    private LibrosRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ConsultaLiteralApplication.class, args);
    }

    public void run(String... args) throws Exception {
        Principal principal = new Principal(repository);
        principal.muestraMenu();
    }
}

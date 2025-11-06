package br.com.cotemig.musicapi;

import br.com.cotemig.musicapi.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MusicApiApplication.class, args);
    }

    @Autowired
    private SeedService seedService;

    @Override
    public void run(String... args) {
        seedService.doSeed();
    }
}

package be.cegeka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
public class GameOfLife {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(GameOfLife.class, args);
    }
}

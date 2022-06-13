package mck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program {
    public static void main(String[] args) throws Exception {
        System.out.print("Hello World - McK");
        SpringApplication.run(Program.class, args);
    }
}

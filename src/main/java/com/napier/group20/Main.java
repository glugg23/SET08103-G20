package com.napier.group20;

import com.napier.group20.utils.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            App.connect("db:3306", 10);
            App.loadDatabase();
            App.disconnect();
        } else {
            App.connect(args[0], 10);
            App.loadDatabase();
            App.disconnect();
        }

        SpringApplication.run(App.class,  args);
    }
}

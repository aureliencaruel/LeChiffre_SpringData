package com;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    /**
     * Logger de la classe
     */
    private static Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }


}

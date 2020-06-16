package com.main;

import com.modele.Voiture;
import com.repo.VoitureRepository;
import com.service.VoitureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {


    /**
     * Logger de la classe
     */
    private static final Logger logger = LogManager.getLogger(ApplicationStartup.class);

    @Autowired
    VoitureRepository repo;

    @Autowired
    VoitureService service;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("OK");

        try {
            Voiture voiture1 = new Voiture("Renault R5", "Renault", "A9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2004"), 10000);
            repo.save(voiture1);

            Voiture voiture2 = new Voiture("Renault Megane", "Renault", "B9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2005"), 20000);
            repo.save(voiture2);

            Voiture voiture3 = new Voiture("Renault Clio", "Renault", "C9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2006"), 30000);
            repo.save(voiture3);

            Voiture voiture4 = new Voiture("Renault Scenic", "Renault", "D9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2007"), 40000);
            repo.save(voiture4);

            Voiture voiture5 = new Voiture("Peugeot 206", "Peugeot", "E9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2008"), 50000);
            repo.save(voiture5);

            Voiture voiture6 = new Voiture("Peugeot 207", "Peugeot", "F9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2009"), 60000);
            repo.save(voiture6);

            Voiture voiture7 = new Voiture("Peugeot 307", "Peugeot", "G9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2010"), 70000);
            repo.save(voiture7);

            Voiture voiture8 = new Voiture("Peugeot 508", "Peugeot", "H9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2011"), 80000);
            repo.save(voiture8);

            Voiture voiture9 = new Voiture("Peugeot 3008", "Peugeot", "I9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2012"), 90000);
            repo.save(voiture9);

            Voiture voiture10 = new Voiture("Peugeot 806", "Peugeot", "J9887TR", new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2013"), 100000);
            repo.save(voiture10);

            // affichage de tous les véhicules en bdd
            Iterator<Voiture> voitures = repo.findAll().iterator();
            while (voitures.hasNext()) {
                Voiture voiture_ = voitures.next();
                logger.info("voiture " + voiture_.toString());
            }

            logger.info("TP 7 = " + service.getTP7A());
            logger.info("TP 7 = " + service.getTP7B());
            logger.info("TP 7 = " + service.getTP7C());
            logger.info("TP 9 = " + service.getTP9());
            logger.info("TP 10 = " + service.getTP10());


        } catch (ParseException e) {
            e.printStackTrace();
        }





    }
}

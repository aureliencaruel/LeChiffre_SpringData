package com.repo;

import com.modele.Voiture;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VoitureRepository extends CrudRepository<Voiture, Integer>, JpaSpecificationExecutor<Voiture> {

    @Query("SELECT b FROM Voiture b WHERE nbKilometres > 50000")
    List<Voiture> listeVoitureAncienne();

    @Query("SELECT b FROM Voiture b WHERE marque = :marque")
    List<Voiture> listeVoitureMarque(@Param("marque") String marque);

    @Query("SELECT b FROM Voiture b ORDER BY dateImmatriculation DESC")
    List<Voiture> troisVoituresImmatriculeesIlyALePlusLongemps();

    List<Voiture> findByMarque(String renault);
}


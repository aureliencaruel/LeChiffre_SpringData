package com.service;

import com.modele.Voiture;
import com.repo.VoitureRepository;
import com.specification.ParentSpecificationsBuilder;
import com.specification.VehiculeSpecificationsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoitureService {

    @Autowired
    VoitureRepository repo;

    public List<Voiture> getTP7A() {
        return repo.listeVoitureAncienne();
    }

    public List<Voiture> getTP7B() {
        return repo.listeVoitureMarque("Renault");
    }

    public List<Voiture> getTP7C() {
        Pageable limitationA3 = PageRequest.of(0, 3);
        return repo.troisVoituresImmatriculeesIlyALePlusLongemps(limitationA3);
    }

    public List<Voiture> getTP9() {
        return repo.findByMarque("Renault");
    }
    public List<Voiture> getTP10() {

        ParentSpecificationsBuilder builder = new VehiculeSpecificationsBuilder();
        Specification spec = Specification.where(builder.build());


        Specification spec_renault = new Specification<Voiture>() {
            public Predicate toPredicate(Root<Voiture> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(builder.equal(root.get("marque"), "renault"));
                return builder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        spec = spec.and(spec_renault);

        return repo.findAll(spec);

    }
}

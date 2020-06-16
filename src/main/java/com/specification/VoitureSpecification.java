package com.specification;

import com.modele.Voiture;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class VoitureSpecification implements Specification<Voiture> {

    private SearchCriteria criteria;

    /**
     *
     */
    private static final long serialVersionUID = -2441828430778923919L;

    @Override
    public Predicate toPredicate(Root<Voiture> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return PredicateUtils.buildPredicate(criteria, root,query, builder);
    }

    public VoitureSpecification(SearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }
}
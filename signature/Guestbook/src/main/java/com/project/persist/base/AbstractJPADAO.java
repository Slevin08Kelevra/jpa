package com.project.persist.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractJPADAO<ENT, ID extends Serializable> {

    @PersistenceContext
    protected EntityManager em;

    protected abstract Class<ENT> getEntClassName();

    protected abstract Class<ID> getIdClassName();

    public List<ENT> findStartsWith(String like, String fieldName) {

        Class<ENT> clazz = getEntClassName();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ENT> query = cb.createQuery(clazz);
        Root<ENT> entitie = query.from(clazz);
        query.select(entitie);
        Expression<String> path = entitie.get(fieldName);
        query.where(cb.like(path, like + "%"));

        /*
         * TypedQuery<ENT> query = em.createQuery(
         * "SELECT p FROM Persona p WHERE apellido like :apellido",
         * getEntClassName()); query.setParameter("apellido", like + "%");
         */

        TypedQuery<ENT> finalQuery = em.createQuery(query);

        return finalQuery.getResultList();

    }

    public List<ENT> findAll() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ENT> cq = cb.createQuery(getEntClassName());
        Root<ENT> rootEntry = cq.from(getEntClassName());
        CriteriaQuery<ENT> all = cq.select(rootEntry);
        TypedQuery<ENT> allQuery = em.createQuery(all);
        return allQuery.getResultList();

    }

    @Transactional
    public void save(ENT entity) {

        em.merge(entity);

    }

    @Transactional
    public void update(ENT entity, ID id) {

        em.merge(entity);

    }

    @Transactional
    public void delete(ID id) {

        ENT entity = em.find(getEntClassName(), id);
        if (entity != null) {
            em.remove(entity);
        }

    }

}

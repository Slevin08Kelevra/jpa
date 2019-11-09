package com.project.persist.area.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.persist.area.ent.Country;
import com.project.persist.area.ent.Country_;
import com.project.persist.area.ent.Guest;
import com.project.persist.area.ent.Persona;

@Component
public class GuestDao {
    // Injected database connection:
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void persist(Guest guest) {
        em.persist(guest);
    }

    // Retrieves all the guests:
    public List<Guest> getAllGuests() {
        TypedQuery<Guest> query = em.createQuery(
                "SELECT g FROM Guest g ORDER BY g.id", Guest.class);
        return query.getResultList();
    }

    public List<Country> getAllCountries() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c",
                Country.class);
        return query.getResultList();
    }

    public List<Country> getCountries(String like) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Country> query = cb.createQuery(Country.class);
        Root<Country> country = query.from(Country.class);
        Expression<String> path = country.get(Country_.name);
        query.where(cb.like(path, like + "%"));

        TypedQuery<Country> finalQ = em.createQuery(query);

        return finalQ.getResultList();
    }

    public List<Persona> getPersonas(String like) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> country = query.from(Persona.class);
        Expression<String> path = country.get("apellido");
        query.where(cb.like(path, like + "%"));

        TypedQuery<Persona> finalQ = em.createQuery(query);

        return finalQ.getResultList();
    }

    public <ENT> List<ENT> findStartsWith(String like, Class<ENT> clazz, String fieldName){

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ENT> query = cb.createQuery(clazz);
        Root<ENT> country = query.from(clazz);
        Expression<String> path = country.get(fieldName);
        query.where(cb.like(path, like + "%"));

        TypedQuery<ENT> finalQ = em.createQuery(query);

        return finalQ.getResultList();

    }

}

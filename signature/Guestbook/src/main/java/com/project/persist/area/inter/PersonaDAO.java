package com.project.persist.area.inter;

import org.springframework.transaction.annotation.Transactional;

import com.project.persist.area.ent.Persona;
import com.project.persist.base.GenericJPADAO;

public interface PersonaDAO extends GenericJPADAO<Persona, Integer> {

    @Transactional
    public void updateFields(Persona patch, Integer id);

}

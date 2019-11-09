package com.project.persist.area.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.persist.area.ent.Persona;
import com.project.persist.area.ent.Persona.PatchedFields;
import com.project.persist.area.inter.PersonaDAO;
import com.project.persist.base.AbstractJPADAO;

@Repository("personaDao")
public class PersonaDAOImp extends AbstractJPADAO<Persona, Integer>
        implements PersonaDAO {

    @Override
    protected Class<Persona> getEntClassName() {
        return Persona.class;
    }

    @Override
    protected Class<Integer> getIdClassName() {
        return Integer.class;
    }

    @Override
    public void updateFields(Persona patch, Integer id) {

        Persona persona = em.find(getEntClassName(), id);
        List<PatchedFields> updated = patch.updatedFields();
        for (PatchedFields field : updated) {

            switch (field) {

            case nombre:
                persona.setNombre(patch.getNombre());
                break;

            case apellido:
                persona.setApellido(patch.getApellido());

            default:
                break;
            }

        }

    }



}

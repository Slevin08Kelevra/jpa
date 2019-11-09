package com.project.persist.base;

import java.io.Serializable;
import java.util.List;

public interface GenericJPADAO<ENT, ID extends Serializable> {

    public List<ENT> findStartsWith(String like, String fieldName);
    public void save(ENT entity);
    public void update(ENT entity, ID id);
    public void delete(ID id);
    public List<ENT> findAll();

}

/*package com.project.persist.area.imp;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.persist.area.repo.Person;



public interface PersonRepo extends CrudRepository<Person, Long>
{
        @Query("{'name' : ?0}")
        public Iterable<Person> searchByName(String personName);

        @Query("{ 'name' : { $regex: ?0 } }")
        public Iterable<Person> begindsWith(String regExp);

}
*/
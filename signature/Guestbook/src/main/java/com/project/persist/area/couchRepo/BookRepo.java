package com.project.persist.area.couchRepo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.project.persist.area.repo.Book;



@Repository
public interface BookRepo extends CouchbaseRepository<Book, Long>
{
}
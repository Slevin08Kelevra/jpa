package com.project.persist.area.repo;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document(expiry = 0)
public class Book {

  @Id
  private long bookId;

  @Field
  private String name;

  @Field
  private long isbnNumber;

  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getIsbnNumber() {
    return isbnNumber;
  }

  public void setIsbnNumber(long isbnNumber) {
    this.isbnNumber = isbnNumber;
  }

  @Override
  public String toString() {
    return "Book [bookId=" + bookId + ", name=" + name + ", isbnNumber=" + isbnNumber + "]";
  }

}

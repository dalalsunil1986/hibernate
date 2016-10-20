package jbr.hibernate.annotation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "NAME", length = 30, nullable = false)
  private String name;

  @Column(name = "ISBN", length = 30, nullable = false)
  private String isbn;

  @Column(name = "AUTHOR", length = 30, nullable = false)
  private String author;

  @Column(name = "YEAR_OF_PUBLISH", length = 30, nullable = false)
  private int yearOfPublish;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYearOfPublish() {
    return yearOfPublish;
  }

  public void setYearOfPublish(int yearOfPublish) {
    this.yearOfPublish = yearOfPublish;
  }

}

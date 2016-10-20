package jbr;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jbr.hibernate.annotation.model.Book;
import jbr.hibernate.annotation.model.User;
import jbr.hibernate.util.DBUtil;

public class AnnotationMainApp {
  Session session = DBUtil.getAnnotationSessionFactory().getCurrentSession();

  public static void main(String[] args) {
    AnnotationMainApp app = new AnnotationMainApp();

    // app.insertRecord();

    // app.createTable();

    // app.readDataWithoutHql();
    // app.readDataWithHql();

    // app.updateRecord(1, "Bala");

    // app.deleteRecord(1);

  }

  public void deleteRecord(int userId) {
    Transaction txn = session.beginTransaction();
    User user = (User) session.get(User.class, userId);
    session.delete(user);
    txn.commit();

    DBUtil.getAnnotationSessionFactory().close();
  }

  public void updateRecord(int userId, String firstName) {
    Transaction txn = session.beginTransaction();

    User user = (User) session.get(User.class, userId);
    user.setFirstname(firstName);
    session.update(user);
    txn.commit();

    DBUtil.getAnnotationSessionFactory().close();
  }

  /**
   * Read data from table without using hql query.
   */
  public void readDataWithoutHql() {
    session.beginTransaction();
    List<User> users = session.createCriteria(User.class).list();
    for (User user : users) {
      System.out.println("First Name: " + user.getFirstname());
      System.out.println("Last Name: " + user.getLastname());
    }

    DBUtil.getAnnotationSessionFactory().close();
  }

  /**
   * Read data from table with hql query.
   */
  public void readDataWithHql() {
    session.beginTransaction();
    List<User> users = session.createQuery("from User").list();
    for (User user : users) {
      System.out.println("First Name: " + user.getFirstname());
      System.out.println("Last Name: " + user.getLastname());
    }

    DBUtil.getAnnotationSessionFactory().close();
  }

  /**
   * Create new table and insert record.
   */
  public void createTable() {
    Book book = new Book();
    book.setName("Java complete reference");
    book.setAuthor("James");
    book.setIsbn("ISBN34343");
    book.setYearOfPublish(2000);

    Transaction txn = session.beginTransaction();
    session.persist(book);
    txn.commit();

    DBUtil.getAnnotationSessionFactory().close();
  }

  /**
   * Insert a new Record.
   */
  public void insertRecord() {
    User user = new User();
    user.setUsername("bala");
    user.setPassword("kumaran");
    user.setFirstname("Bala");
    user.setLastname("Kumarn");
    user.setAddress("bangalore");
    user.setPhone(Long.valueOf(8600600));

    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    DBUtil.getAnnotationSessionFactory().close();
  }
}

package jbr;

import org.hibernate.Session;

import jbr.hibernate.model.User;
import jbr.hibernate.util.DBUtil;

public class MainApp {
  public static void main(String[] args) {

    User user = new User();
    user.setUsername("ranjiths");
    user.setPassword("sekarc");
    user.setFirstname("Ranjith");
    user.setLastname("Sekar");
    user.setAddress("chennai");
    user.setPhone(Long.valueOf(96000900));

    Session session = DBUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.save(user);
    session.getTransaction().commit();
    DBUtil.getSessionFactory().close();
  }
}

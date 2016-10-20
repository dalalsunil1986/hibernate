package jbr.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBUtil {

  private static SessionFactory sessionFactory;
  private static SessionFactory annotationSessionFactory;

  public static SessionFactory getSessionFactory() {
    if (null == sessionFactory) sessionFactory = createSessionFactory("hibernate.cfg.xml");
    return sessionFactory;
  }

  public static SessionFactory getAnnotationSessionFactory() {
    if (null == annotationSessionFactory)
      annotationSessionFactory = createSessionFactory("hibernate-annotation.cfg.xml");
    return annotationSessionFactory;
  }

  private static SessionFactory createSessionFactory(String configFile) {
    try {
      Configuration configuration = new Configuration();
      configuration.configure(configFile);
      System.out.println("Configuration Initiated...");

      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
          .applySettings(configuration.getProperties()).build();

      SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

      return sessionFactory;
    } catch (Throwable ex) {
      System.err.println("SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

}

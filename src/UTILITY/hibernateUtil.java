package UTILITY;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class hibernateUtil {



    public  static Session getSession(){
        SessionFactory sf;

        sf  = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s;
        s = sf.openSession();
        return s;

    }
}

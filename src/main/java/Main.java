import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.StubNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("sangeetha");
        a1.setTech("java");

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Hp");
        l2.setRam(32);

        l1.setAlien(a1);
        l2.setAlien(a1);
        a1.setLaptop(List.of(l1,l2));


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Alien.class);
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(l1);
        session.persist(l2);
        session.persist(a1);

        transaction.commit();


        session.close();
        sf.close();


    }
}

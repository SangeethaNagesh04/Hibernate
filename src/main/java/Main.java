import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.StubNotFoundException;

public class Main {
    public static void main(String[] args) {

        Alien alien = new Alien();
        alien.setAid(101);
        alien.setAname("sangeetha");
        alien.setTech("java");

        Laptop l1 = new Laptop();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        alien.setLaptop(l1);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Alien.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(alien);

        transaction.commit();

       Alien a1 = session.get(Alien.class, 101);
        System.out.println(a1);

        session.close();
        sf.close();


    }
}

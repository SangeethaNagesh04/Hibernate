import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.rmi.StubNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Query query = session.createQuery("from Laptop where brand='Hp'");

        List<Laptop> laptops = query.getResultList();

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

        session.close();

        sf.close();


    }
}

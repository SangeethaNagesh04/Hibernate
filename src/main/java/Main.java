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

        String brand = "Hp";

        Query query = session.createQuery("select ram from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Integer> laptops = query.getResultList();

        System.out.println(laptops);
        session.close();

        sf.close();


    }
}

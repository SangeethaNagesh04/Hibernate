import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Laptop.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();


        Laptop laptop = session.byId(Laptop.class).getReference(1);
        //System.out.println(laptop);

        session.close();

        sf.close();


    }
}

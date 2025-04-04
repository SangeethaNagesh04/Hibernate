import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.rmi.StubNotFoundException;

public class Main {
    public static void main(String[] args) {

        Student s = new Student();
        s.setRollNo(104);
        s.setSname("nagesh");
        s.setAge(58);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        Student s1 = session.get(Student.class, 104);
        session.remove(s1);
        transaction.commit();

        session.close();
        sf.close();


    }
}

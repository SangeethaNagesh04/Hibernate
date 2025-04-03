import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s = new Student();
        s.setRollNo(102);
        s.setSname("sampi");
        s.setAge(30);


        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Student.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s);
        transaction.commit();

        session.close();
        sf.close();

    }
}

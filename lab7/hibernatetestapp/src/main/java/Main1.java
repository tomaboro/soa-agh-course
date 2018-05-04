import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student1 = new Student();
        student1.setFirstName("Bob");
        student1.setAge(26);
        session.save(student1);

        Student student2 = new Student();
        student2.setFirstName("Tomek");
        student2.setAge(22);
        session.save(student2);

        Student student3 = new Student();
        student3.setFirstName("Iza");
        student3.setAge(22);
        session.save(student3);

        session.getTransaction().commit();
        session.close();
    }
}

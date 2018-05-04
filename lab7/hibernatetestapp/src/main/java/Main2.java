import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Main2 {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Student> students = session.createQuery("from student_v2").list();

        session.close();

        for (Student st : students) {
            System.out.println(st.getId()+". "+st.getFirstName()+" "+st.getAge());
        }
    }
}
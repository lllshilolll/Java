import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.getCurrentSession(); {

            session.beginTransaction();
        Student student = session.get(Student.class, 33);
        List<Subscription> subscriptions = student.getSubscriptions();
        for (Subscription subscription : subscriptions) {
            System.out.println(subscription.getStudent().getName());
            System.out.println(subscription.getCourse().getName());
            System.out.println(subscription.getSubscriptionDate());
        }

        session.getTransaction().commit();
    }
}}
/**
 * StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
 * .configure("hibernate.cfg.xml").build();
 * Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
 * <p>
 * <p>
 * SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
 * Session session = sessionFactory.openSession();
 * <p>
 * /**     String hql = "From " + Course.class.getSimpleName() + " where price > 120000";
 * <p>
 * List<Course> courses = session.createQuery(hql).getResultList();
 * for(Course course:courses){
 * System.out.println(course.getName() + " " + course.getPrice());
 * }sessionFactory.close();private static String getCourseByID(int id, SessionFactory sessionFactory) {
 * Course course = null;
 * String st;
 * try (Session session = sessionFactory.openSession()) {
 * course = session.get(Course.class, id);
 * } catch (Exception ex) {
 * ex.printStackTrace();
 * }
 * if (sessionFactory == null) {
 * st = "JDBS connection don't exists";
 * } else {
 * st = course.getName() + " " + course.getStudentsCount();
 * }
 * <p>
 * <p>
 * return st;
 * <p>
 * }
 */


/**private static String getCourseByID(int id, SessionFactory sessionFactory) {
 Course course = null;
 String st;
 try (Session session = sessionFactory.openSession()) {
 course = session.get(Course.class, id);
 } catch (Exception ex) {
 ex.printStackTrace();
 }
 if (sessionFactory == null) {
 st = "JDBS connection don't exists";
 } else {
 st = course.getName() + " " + course.getStudentsCount();
 }


 return st;

 }*/





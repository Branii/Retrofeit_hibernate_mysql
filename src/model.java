import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class model {
    
        public static void save(users user) { // save to mysql database users table
        try {
            Configuration configuration = config.configureHibernate();
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            //StatelessSession statelessSession = sessionFactory.openStatelessSession();
            Transaction transaction = session.beginTransaction();
            //statelessSession.beginTransaction();
            //statelessSession.insert(user);
            session.persist(user);
            //statelessSession.getTransaction().commit();
            transaction.commit();
            sessionFactory.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

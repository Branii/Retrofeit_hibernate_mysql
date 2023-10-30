import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    public static Configuration configureHibernate() {

        Configuration configuration = new Configuration();

        // Configure database connection properties
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root"); //change for pc

        // Add annotated entity classes
        configuration.addAnnotatedClass(Users.class);
        // Add more entity classes as needed
        return configuration;
    }
}


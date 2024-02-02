import entity.Customer;
import lib.config.SessionFactoryConfig;
import org.hibernate.Session;

public class AppInitializer {
    public static void main(String[] args) {

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setAddress("Colombo");
        customer.setSalary(100000);

        session.save(customer);

    }
}
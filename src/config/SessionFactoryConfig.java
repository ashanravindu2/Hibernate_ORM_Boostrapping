package config;

import entity.Customer_old;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        // private constructor

        //1. create a service registry



        //2. create a metadata source
/*
        sessionFactory = new MetadataSources( new StandardServiceRegistryBuilder()
                .configure()
                .build())
                .addAnnotatedClass(Customer.class)//addAnnotatedClass() is used to add the annotated class to the metadata

                // addAnnotatedClass() is used to add the annotated class to the metadata
                .getMetadataBuilder()
                .build()
                .buildSessionFactory();*/


        //short simplify
        sessionFactory= new Configuration()
                .configure()
                .addAnnotatedClass(Customer_old.class)
                .buildSessionFactory();

    }

    public static SessionFactoryConfig getInstance() {
        return  (factoryConfig == null) ?
                factoryConfig = new SessionFactoryConfig()
                : factoryConfig;
    }

    public Session getSession() {


        //4. create a session and open a transaction
        return sessionFactory.openSession();

        //5. close the session
    }
}

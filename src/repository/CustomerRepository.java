package repository;

import config.SessionFactoryConfig;
import entity.Customer_old;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CustomerRepository {
private Session session;


    public CustomerRepository(){
        session = SessionFactoryConfig.getInstance().getSession();
    }


    public  int saveCustomer(Customer_old customer){

        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int) session.save(customer);
            transaction.commit();
            session.close();
            return customerId;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return -1;
        }
    }

    public Customer_old getCustomer(int id){
        try {
           Customer_old customer = session.get(Customer_old.class,id);
            session.close();
            return customer;
        }catch (Exception e){
            session.close();
            e.printStackTrace();
            throw e;
        }
    }

    public boolean updateCustomer(Customer_old customer){
        Transaction transaction = session.beginTransaction();
        try{
            session.update(customer);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteCustomer(Customer_old customer){
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(customer);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
}

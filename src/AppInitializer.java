import embedded.MobileNo;
import embedded.NameIdentifier;
import entity.Customer_old;
import repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        //save
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.saveCustomer(getCustomer());

        //get
        customerRepository=new CustomerRepository();
        Customer_old customer = customerRepository.getCustomer(1);
        System.out.println(customer);

        //update
        customerRepository=new CustomerRepository();
        customer.setAddress("Matara");
       boolean isupdate =  customerRepository.updateCustomer(customer);
       if (isupdate){
           System.out.println("UPDATED");
       }

        //delete
        customerRepository=new CustomerRepository();
        customerRepository.deleteCustomer(customer);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

       /* System.out.println("Update Customer");
        //update session
        Session updateSession = SessionFactoryConfig
                .getInstance()
                .getSession();


        Transaction updateTransaction = updateSession.beginTransaction();

        Customer existsCus = updateSession.get(Customer.class,1);
        existsCus.setAddress("Matara");
        updateSession.update(existsCus);
        updateTransaction.commit();
        updateSession.close();

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("Delete Customer");
//delete session*/
        /*Session deleteSession = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction deleteTransaction = deleteSession.beginTransaction();

        Customer existedeleteCus = deleteSession.get(Customer.class,1);
        deleteSession.delete(existedeleteCus);
        deleteTransaction.commit();
        deleteSession.close();*/
    }

    private static Customer_old getCustomer() {
        Customer_old customer = new Customer_old();
        customer.setId(1);
        customer.setName(getNameIndentifier());
        customer.setAddress("Colombo");
        customer.setSalary(100000);
        customer.setAge(21);
        customer.setMobileNos(getMobileNo());

        return customer;
    }

    private static List<MobileNo> getMobileNo() {
        MobileNo dialog = new MobileNo("dialog","0773562532");
        MobileNo mobitel = new MobileNo("mobitel","0717363782");
        MobileNo airtel = new MobileNo("airtel","0728737732");
        List<MobileNo> mobileNoList = new ArrayList<>();
        mobileNoList.add(dialog);
        mobileNoList.add(mobitel);
        mobileNoList.add(airtel);
         return mobileNoList;
    }

    private static NameIdentifier getNameIndentifier() {
        NameIdentifier nameIdentifier = new NameIdentifier();
        nameIdentifier.setFirstName("Saman");
        nameIdentifier.setMiddleName("Amila");
        nameIdentifier.setLastName("Perera");

        return  nameIdentifier;
    }


}
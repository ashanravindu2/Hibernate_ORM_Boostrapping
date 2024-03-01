package entity;

import embedded.MobileNo;
import embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// Two types of annotations are used to map a class to a table

// 1. @Entity(name = "customer")
// 2.
    @Entity // this is used to tell hibernate that this class is an entity
    @Table(name = "customer") // this is used to tell hibernate that this class is mapped to a table
    public class Customer_old {


    @Id // this is used to tell hibernate that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY )//
    @Column(name = "customer_id") // this is used to tell hibernate that this field is a column in the table
    private int id;

    @Column(name = "customer_name")
    private NameIdentifier name;

    @Column(name = "customer_address",length = 100,nullable = false)//set length,nullable,unique
    private String address;

    @Column(name = "customer_salary")
    private double salary;

    @Column(name = "customer_age")
    @Transient
    private int age; //database save wenne na.. "Transeint" hind

    @ElementCollection
    @CollectionTable(name = "customer_mobile_no",joinColumns =
    @JoinColumn(name = "customer_id"))
    private List<MobileNo>mobileNos = new ArrayList<>();



    @CreationTimestamp
    private Timestamp createdDateTime; //data insert time and date

    @UpdateTimestamp
    private Timestamp updateDateTime; //data update time and date

    public Customer_old() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NameIdentifier getName() {
        return name;
    }

    public void setName(NameIdentifier name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<MobileNo> getMobileNos() {
        return mobileNos;
    }

    public void setMobileNos(List<MobileNo> mobileNos) {
        this.mobileNos = mobileNos;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Timestamp getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Customer_old(int id, NameIdentifier name, String address, double salary, int age, List<MobileNo> mobileNos, Timestamp createdDateTime, Timestamp updateDateTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.age = age;
        this.mobileNos = mobileNos;
        this.createdDateTime = createdDateTime;
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", age=" + age +
             //   ", mobileNos=" + mobileNos +
                ", createdDateTime=" + createdDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}

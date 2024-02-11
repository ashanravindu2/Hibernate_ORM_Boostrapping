package entity;

import embedded.NameIdentifier;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// Two types of annotations are used to map a class to a table

// 1. @Entity(name = "customer")
// 2.
 @Entity // this is used to tell hibernate that this class is an entity
 @Table(name = "customer") // this is used to tell hibernate that this class is mapped to a table
public class Customer {

     @Id // this is used to tell hibernate that this field is the primary key
     @Column(name = "customer_id") // this is used to tell hibernate that this field is a column in the table
     @GeneratedValue(strategy = GenerationType.AUTO )//

    private int id;

    @Column(name = "customer_name")
    private NameIdentifier name;

    @Column(name = "customer_address",length = 100,nullable = false)//set length,nullable,unique
    private String address;

    @Column(name = "customer_salary")
    private double salary;

    @Column(name = "customer_phone")
    private int phone;

    @Column(name = "customer_age")
    @Transient
    private int age; //database save wenne na "Transeint"

    @CreationTimestamp
    private Timestamp createdDateTime; //data insert time and date

    @UpdateTimestamp
    private Timestamp updateDateTime;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", phone=" + phone +
                ", age=" + age +
                ", createdDateTime=" + createdDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
}

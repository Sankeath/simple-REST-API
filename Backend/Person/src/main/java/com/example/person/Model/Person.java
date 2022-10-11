package com.example.person.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
//import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class Person {



    @Id
    private Long id;
    @Column (name = "person_name")

    private String name;
    @Column (name = "address")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String address;
    @Column (name = "postCode")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String postCode;
    @Column (name = "age")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String age;
    @Column (name = "job")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String job;
    @Column (name = "email")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String email;
    @Column (name = "phoneNo")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String phoneNo;

    public Person(Long id,String name,String address,String postCode,String age,String job,String email,String phoneNo){
        this.id = id;
        this.name = name;
        this.address = address;
        this.postCode = postCode;
        this.age = age;
        this.job = job;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Person {" +
                "id="+id+
                "name="+name+
                "address="+address+
                "postcode="+postCode+
                "age="+age+
                "job="+job+
                "email="+email+
                "phoneNo="+phoneNo+"}";

    }
}

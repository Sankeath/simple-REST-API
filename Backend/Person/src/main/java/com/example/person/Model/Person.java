package com.example.person.Model;


import javax.persistence.*;

@Entity
@Table(name = "Persons")
public class Person {

    @Id
    private Long id;
    @Column (name = "Name")
    private String name;
    @Column (name = "Address")
    private String address;
    @Column (name = "PostCode")
    private String postCode;
    @Column (name = "Age")
    private String age;
    @Column (name = "Job")
    private String job;
    @Column (name = "Email")
    private String email;
    @Column (name = "PhoneNo")
    private String phoneNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
}

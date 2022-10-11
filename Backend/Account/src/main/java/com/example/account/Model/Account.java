package com.example.account.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;
//import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    private Long id;
    @Column (name = "account_type")
    private String account_type;
    @Column (name = "account_number")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String account_number;
    @Column (name = "account_name")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String account_name;
    @Column (name = "balance")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String balance;
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    public Account(){}

    public Account(Long id,String account_type,String account_number,String account_name,String balance,Date date){
        this.id = id;
        this.account_type = account_type;
        this.account_number = account_number;
        this.account_name = account_name;
        this.balance = balance;
        this.date = date;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getAccount_type(){
        return account_type;
    }
    public void setAccount_type(String account_type){
        this.account_type = account_type;
    }

    public String getAccount_number(){
        return account_number;
    }
    public void setAccount_number(String account_number){
        this.account_number = account_number;
    }

    public String getAccount_name(){
        return account_name;
    }
    public void setAccount_name(String account_name){
        this.account_name = account_name;
    }

    public String getBalance(){
        return balance;
    }
    public void setBalance(String balance){
        this.balance=balance;
    }

    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
}

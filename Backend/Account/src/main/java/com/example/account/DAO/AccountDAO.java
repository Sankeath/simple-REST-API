package com.example.account.DAO;

import com.example.account.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.account.Repository.AccountRepository;


import java.util.List;
import java.util.Optional;

@Repository
public class AccountDAO {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccountList(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(Long id){
        return accountRepository.findById(id);
    }

    public boolean updateAccount(Long id,Account account){
        Optional<Account> toUpdate = getAccount(id);
        boolean returnStatement = false;
        if (toUpdate.isPresent()){
            toUpdate.get().setAccount_type(account.getAccount_type());
            toUpdate.get().setAccount_number(account.getAccount_number());
            toUpdate.get().setAccount_name(account.getAccount_name());
            toUpdate.get().setBalance(account.getBalance());
            toUpdate.get().setDate(account.getDate());
            accountRepository.save(toUpdate.get());
            returnStatement = true;
        }
        return returnStatement;
    }

    public void deleteAccount(Long id){
        Optional<Account> toDelete = accountRepository.findById(id);
        if (toDelete.isPresent()){
            accountRepository.delete(toDelete.get());
        }
    }

    public boolean createAccount(Account account){

        boolean isCreated =true;
        try {
            accountRepository.save(account);
        }
        catch (Exception e){
            isCreated = false;

        }

        return isCreated;
    }

}

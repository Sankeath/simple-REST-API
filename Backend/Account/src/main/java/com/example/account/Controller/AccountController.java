package com.example.account.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.account.DAO.AccountDAO;
import com.example.account.Model.Account;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/accounts")
public class AccountController {

    @Autowired
    private AccountDAO accountDAO;

    //Get all persons
    @GetMapping(path = "/account", produces = "application/json")
    public List<Account> getAccountList(){
        return accountDAO.getAccountList();
    }

    //Get person by id
    @GetMapping(path = "/{id}", produces = "application/json")
    public Account getAccount(@PathVariable Long id){
        Optional<Account> person = accountDAO.getAccount(id);
        return person.get();
    }

    @PutMapping(path = "/account", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateAccount(@RequestBody Account account){

        if (accountDAO.updateAccount(account.getId(),account)){
            return new ResponseEntity<>("Account info updated",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Account to update not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/account",consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> deleteAccount(@RequestBody Account account){
        accountDAO.deleteAccount(account.getId());
        return new ResponseEntity<>("Account specified by id was deleted",HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json",produces = "application/json")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {

        boolean isCreated;

        isCreated = accountDAO.createAccount(account);
        if (isCreated) {
            return new ResponseEntity<>("Account created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not created", HttpStatus.NOT_FOUND);
        }
    }

}

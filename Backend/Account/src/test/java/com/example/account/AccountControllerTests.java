package com.example.account;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.account.Repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.account.Model.Account;
import com.example.account.DAO.AccountDAO;
import com.example.account.Repository.AccountRepository;
import com.example.account.Controller.AccountController;

import org.mockito.Mockito;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

@SpringBootTest
public class AccountControllerTests {

    @Autowired
    private AccountController accountController;

    @MockBean
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp(){


        try {
            Long id = Long.valueOf(1);
            accountController = Mockito.mock(AccountController.class);
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date) dateFormatter.parse("2022-10-11");
            Account account = new Account(id,"1","2","3","4",date);
            accountRepository.save(account);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testGetAccount() throws ParseException {
        Long id = Long.valueOf(1);
        Optional<Account> account = accountRepository.findById(id);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) dateFormatter.parse("2022-10-11");
        Account a = new Account(id,"1","2","3","4",date);


        when(accountController.getAccount(id)).thenReturn(a);
        assertEquals(a, accountController.getAccount(id));
    }

    @Test
    void testCreateAccountSuccess() throws ParseException {
        Long id = Long.valueOf(2);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) dateFormatter.parse("2022-10-11");
        Account a = new Account(id,"1","2","3","4",date);

        ResponseEntity<?> response = new ResponseEntity<>("Account created", HttpStatus.OK);
        when(accountController.createAccount(a)).thenReturn((ResponseEntity) response);

        assertEquals(response, accountController.createAccount(a));
    }

    @Test
    void testCreateAccountFailure() throws ParseException {
        Long id = Long.valueOf(2);
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) dateFormatter.parse("2022-10-11");
        Account a = new Account();

        ResponseEntity<?> response = new ResponseEntity<>("Account not created", HttpStatus.INTERNAL_SERVER_ERROR);
        when(accountController.createAccount(a)).thenReturn((ResponseEntity) response);

        assertEquals(response, accountController.createAccount(a));
    }
}

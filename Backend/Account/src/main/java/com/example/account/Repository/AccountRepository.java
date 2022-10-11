package com.example.account.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.account.Model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{


}

package com.workintech.s19d2.repository;
import com.workintech.s19d2.entity.Account;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
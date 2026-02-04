package com.workintech.s19d2.service;
import com.workintech.s19d2.repository.AccountRepository;
import com.workintech.s19d2.entity.Account;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);

        if (accountOptional.isPresent()) {
            return accountOptional.get();
        }
        throw new RuntimeException("Account with id -> " + id + " not found!! ");
    }

    @Override
    public Account update(Long id, Account account) {
        Account existingAccount = findById(id);
        existingAccount.setName(account.getName());

        return accountRepository.save(existingAccount);
    }

    @Override
    public void delete(Long id) {
        Account account = findById(id);
        accountRepository.delete(account);
    }

}


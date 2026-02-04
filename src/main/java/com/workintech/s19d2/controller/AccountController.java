package com.workintech.s19d2.controller;
import com.workintech.s19d2.service.AccountService;
import com.workintech.s19d2.entity.Account;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    @PostMapping
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountService.delete(id);
    }


}


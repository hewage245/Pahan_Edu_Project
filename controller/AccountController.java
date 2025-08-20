package com.example.PahanaEduProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PahanaEduProject.model.Account;
import com.example.PahanaEduProject.repository.AccountRepository;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "*")  // allow requests from your HTML page
public class AccountController {

    private final AccountRepository accountRepo;

    public AccountController(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    // Create account
    @PostMapping
    public Account addAccount(@RequestBody Account account) {
        return accountRepo.save(account);
    }

    // Get all accounts
    @GetMapping
    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    // Update account
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable String id, @RequestBody Account updatedAccount) {
        return accountRepo.findById(id).map(acc -> {
            acc.setAccountNumber(updatedAccount.getAccountNumber());
            acc.setName(updatedAccount.getName());
            acc.setAddress(updatedAccount.getAddress());
            acc.setTelephoneNumber(updatedAccount.getTelephoneNumber());
            acc.setUnitsConsumed(updatedAccount.getUnitsConsumed());
            return accountRepo.save(acc);
        }).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    // Delete account
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountRepo.deleteById(id);
    }
}

package com.shraddhaorg.library.LibraryManagement.controller;

import com.shraddhaorg.library.LibraryManagement.entities.Transaction;
import com.shraddhaorg.library.LibraryManagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Issue a book
    @PostMapping
    public Transaction issueBook(@RequestBody Transaction transaction) {
        return transactionService.issueBook(transaction);
    }

    // Return a book
    @PutMapping("/{id}/return")
    public Transaction returnBook(@PathVariable Long id) {
        return transactionService.returnBook(id);
    }

    // Get all transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }
}

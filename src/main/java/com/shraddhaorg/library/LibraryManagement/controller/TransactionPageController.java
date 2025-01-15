package com.shraddhaorg.library.LibraryManagement.controller;

import com.shraddhaorg.library.LibraryManagement.entities.Transaction;
import com.shraddhaorg.library.LibraryManagement.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionPageController {

    @Autowired
    private TransactionService transactionService;

    // Display all transactions
    @GetMapping
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transaction-list"; // Renders templates/transaction-list.html
    }

    // Show form to add a new transaction
    @GetMapping("/add")
    public String showAddTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "add-transaction"; // Renders templates/add-transaction.html
    }

    // Handle form submission for adding a new transaction
   /*** @PostMapping("/add")
    public String addTransaction(@ModelAttribute Transaction transaction) {
        transactionService.addTransaction(transaction);
        return "redirect:/transactions"; // Redirect to transaction list
    }**/
}

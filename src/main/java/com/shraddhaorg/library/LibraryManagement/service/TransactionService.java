package com.shraddhaorg.library.LibraryManagement.service;

import com.shraddhaorg.library.LibraryManagement.entities.Book;
import com.shraddhaorg.library.LibraryManagement.entities.Transaction;
import com.shraddhaorg.library.LibraryManagement.repository.BookRepository;
import com.shraddhaorg.library.LibraryManagement.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    private BookRepository bookRepository;
     public Transaction returnBook(Long transactionId){
         Transaction transaction =  transactionRepository.findById(transactionId).orElse(null);
         if(transaction != null){
             transaction.setReturnDate(LocalDate.now());
             return transactionRepository.save(transaction);
         }
         return null;
     }
     // Get all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get transaction by ID
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction issueBook(Transaction transaction) {
        // Validate book and user (you can add validation logic here)
        if (transaction.getBook() == null || transaction.getUser() == null) {
            throw new IllegalArgumentException("Book and User must be provided.");
        }

        // Set the issue date to today
        transaction.setIssueDate(LocalDate.now());

        // Ensure the book is marked as unavailable
        Book book = transaction.getBook();
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is already issued.");
        }
        book.setAvailable(false);

        // Save the transaction and update the book
        transactionRepository.save(transaction);

        bookRepository.save(book); // Update the book's availability status

        return transaction;
    }

}


package com.shraddhaorg.library.LibraryManagement.repository;

import com.shraddhaorg.library.LibraryManagement.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

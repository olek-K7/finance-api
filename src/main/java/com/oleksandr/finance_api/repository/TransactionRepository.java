package com.oleksandr.finance_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oleksandr.finance_api.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

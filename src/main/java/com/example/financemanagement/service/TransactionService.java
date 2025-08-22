package com.example.financemanagement.service;

import com.example.financemanagement.dto.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);
    TransactionDTO getTransactionById(Long id);
    TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO);
    void deleteTransaction(Long id);
    TransactionDTO findTransactionByDescription(String description);
}
package com.example.financemanagement.impl;

import com.example.financemanagement.dto.TransactionDTO;
import com.example.financemanagement.repository.TransactionRepository;
import com.example.financemanagement.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return null;
    }

    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public void deleteTransaction(Long id) {

    }

    @Override
    public TransactionDTO findTransactionByDescription(String description) {
        return null;
    }
}

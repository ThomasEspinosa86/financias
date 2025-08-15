package com.example.financemanagement.repository;

import com.example.financemanagement.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
   Transaction encontrarPorDescripcion(String descripcion);

}

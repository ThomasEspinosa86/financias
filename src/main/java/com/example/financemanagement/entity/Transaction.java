package com.example.financemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idTransaction;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name = "type", nullable = false,length = 50)
    private String type;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
    @Column(name = "description", nullable = false, length = 255)
    private String description;
    @Column(name = "trasaction_date", nullable = false)
    private LocalDateTime date;
    @Column(name = "status", nullable = false, length = 50)
    private String status;


}

package com.example.financemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "saving_movements")
@Data
public class SavingMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_saving_movement")
    private Long idSavingMovement;

    @ManyToOne
    @JoinColumn(name = "id_saving_plan", nullable = false)
    private SavingPlan savingPlan;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "movement_type", nullable = false, length = 50) // Depósito o Retiro
    private String movementType;

    @Column(name = "movement_date", nullable = false)
    private LocalDateTime movementDate;
}

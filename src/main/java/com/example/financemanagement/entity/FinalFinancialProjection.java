package com.example.financemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "final_financial_projection")
@Data
public class FinalFinancialProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_projection")
    private Long idProjection;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "projected_amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal projectedAmount;

    @Column(name = "target_date", nullable = false)
    private LocalDate targetDate;

    @Column(name = "status", nullable = false, length = 50) // Activo, Completado, Cancelado
    private String status;
}

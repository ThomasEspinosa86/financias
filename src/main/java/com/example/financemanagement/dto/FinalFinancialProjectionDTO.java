package com.example.financemanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FinalFinancialProjectionDTO {
    private Long id;
    private Double projectedIncome;
    private Double projectedExpenses;
    private Double projectedSavings;
    private String projectionDate;
    private Long userId;

}

package com.example.financemanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SavingPlanDTO {
    private Long id;
    private String name;
    private Double targetAmount;
    private String targetDate;
    private Double currentAmount;
    private Long userId;

}

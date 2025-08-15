package com.example.financemanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CapitalizationSettingsDTO {
    private Long id;
    private String frequency; // e.g., "monthly", "quarterly", "annually"
    private Double interestRate; // e.g., 5.0 for 5%
    private Long userId; // ID of the user these settings belong to
}

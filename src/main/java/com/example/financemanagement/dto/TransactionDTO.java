package com.example.financemanagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionDTO {
    private Long id;
    private String type;
    private Double amount;
    private String category;
    private String date;
    private String description;
    private Long userId;

}

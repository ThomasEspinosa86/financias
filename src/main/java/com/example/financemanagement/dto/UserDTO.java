package com.example.financemanagement.dto;

import com.example.financemanagement.repository.UserRepository;
import com.example.financemanagement.service.UserService;
import lombok.*;
import org.springframework.stereotype.Service;
// paar los metodos de servide User

//REPOSITORIOS



@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO  {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;

}

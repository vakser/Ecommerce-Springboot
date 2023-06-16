package com.ecommerce.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 10, message = "First name must be from 3 to 10 characters long")
    private String firstName;
    @Size(min = 3, max = 10, message = "Last name must be from 3 to 10 characters long")
    private String lastName;
    private String username;
    @Size(min = 5, max = 15, message = "Password must be from 5 to 15 characters long")
    private String password;
    private String repeatPassword;

}

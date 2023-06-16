package com.ecommerce.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    @Size(min = 3, max = 15, message = "First name should consist of 3 - 15 characters")
    private String firstName;
    @Size(min = 3, max = 15, message = "Last name should consist of 3 - 15 characters")
    private String lastName;
    private String username;
    private String country;
    @Size(min = 5, max = 20, message = "Password should consist of 5 - 20 characters")
    private String password;
    private String repeatPassword;
}

package com.ktuan28.eco_check.dto.request;

import com.ktuan28.eco_check.entity.roleEnums.RoleEnums;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotBlank(message = "Full name cannot be blank")
    private String fullName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email format is invalid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotBlank(message = "Phone cannot be blank")
    private String phone;

    private RoleEnums role;


}


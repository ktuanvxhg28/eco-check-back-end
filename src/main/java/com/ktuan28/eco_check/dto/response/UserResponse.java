package com.ktuan28.eco_check.dto.response;

import com.ktuan28.eco_check.entity.roleEnums.RoleEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String fullName;
    private String email;
    private String address;
    private String phone;
    private RoleEnums role;

}

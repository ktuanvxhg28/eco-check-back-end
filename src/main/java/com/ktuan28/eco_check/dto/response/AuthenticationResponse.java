package com.ktuan28.eco_check.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    private String token;
    private boolean authenticated;
    private UserResponse user;
}

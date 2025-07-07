package com.ktuan28.eco_check.service;

import com.ktuan28.eco_check.dto.request.AuthenticationRequest;
import com.ktuan28.eco_check.dto.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}

package com.ktuan28.eco_check.controller;

import com.ktuan28.eco_check.dto.request.AuthenticationRequest;
import com.ktuan28.eco_check.dto.request.IntrospectRequest;
import com.ktuan28.eco_check.dto.response.ApiResponse;
import com.ktuan28.eco_check.dto.response.AuthenticationResponse;
import com.ktuan28.eco_check.dto.response.IntrospectResponse;
import com.ktuan28.eco_check.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import jakarta.validation.Valid;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/token")
    public ResponseEntity<ApiResponse<AuthenticationResponse>> authenticate(
            @RequestBody @Valid AuthenticationRequest request) {

        AuthenticationResponse authResponse = authenticationService.authenticate(request);

        return ResponseEntity.ok(
                new ApiResponse<>(200, "Login successful", authResponse)
        );
    }

    @PostMapping("/introspect")
    public ResponseEntity<ApiResponse<IntrospectResponse>> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ResponseEntity.ok(
                ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build());
    }




}

package com.ktuan28.eco_check.controller;

import com.ktuan28.eco_check.dto.request.VehicleCreateRequest;
import com.ktuan28.eco_check.dto.request.VehicleUpdateRequest;
import com.ktuan28.eco_check.dto.response.ApiResponse;
import com.ktuan28.eco_check.dto.response.VehicleResponse;
import com.ktuan28.eco_check.service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vehicles")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;
    private final Long DEFAULT_OWNER_ID = 3L;

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getAllVehicles() {
        List<VehicleResponse> vehicle = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<VehicleResponse>> getVehicleById(
            @PathVariable("id") Long ownerId) {
        List<VehicleResponse> vehicle = vehicleService.getVehicleByOwnerId(DEFAULT_OWNER_ID);
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse<VehicleResponse>> updateVehicle(
            @PathVariable("id") Long vehicleId,
            @RequestBody @Valid VehicleUpdateRequest updateRequest
    ) {
        VehicleResponse vehicleResponse = vehicleService.updateVehicleById(vehicleId, updateRequest);

        ApiResponse<VehicleResponse> apiResponse = new ApiResponse<>(
                200,
                "Vehicle update successfully",
                vehicleResponse
        );

        return ResponseEntity.ok(apiResponse);
    }








}

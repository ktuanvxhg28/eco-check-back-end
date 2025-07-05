package com.ktuan28.eco_check.controller;

import com.ktuan28.eco_check.dto.VehicleDTO;
import com.ktuan28.eco_check.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vehicles")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        List<VehicleDTO> vehicle = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(
            @PathVariable("id") Long vehicleId) {
        VehicleDTO vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok(vehicle);
    }

}

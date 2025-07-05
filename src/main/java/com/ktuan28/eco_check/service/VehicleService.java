package com.ktuan28.eco_check.service;

import com.ktuan28.eco_check.dto.VehicleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<VehicleDTO> getAllVehicles();

    VehicleDTO getVehicleById(Long vehicleId);

}

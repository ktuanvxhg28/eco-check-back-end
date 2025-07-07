package com.ktuan28.eco_check.service;

import com.ktuan28.eco_check.dto.request.VehicleCreateRequest;
import com.ktuan28.eco_check.dto.request.VehicleUpdateRequest;
import com.ktuan28.eco_check.dto.response.VehicleResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<VehicleResponse> getAllVehicles();

    List<VehicleResponse> getVehicleByOwnerId(Long ownerId);

    VehicleResponse updateVehicleById(Long vehicleId, VehicleUpdateRequest updateRequest);

    VehicleResponse createVehicle(Long ownerId ,VehicleCreateRequest vehicleCreateRequest);


}

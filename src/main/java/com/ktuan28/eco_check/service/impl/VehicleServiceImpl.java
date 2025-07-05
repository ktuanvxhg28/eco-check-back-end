package com.ktuan28.eco_check.service.impl;

import com.ktuan28.eco_check.dto.VehicleDTO;
import com.ktuan28.eco_check.entity.Vehicle;
import com.ktuan28.eco_check.exception.ResourceNotFoundException;
import com.ktuan28.eco_check.mapper.VehicleMapper;
import com.ktuan28.eco_check.repository.VehicleRepository;
import com.ktuan28.eco_check.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map((vehicle) -> VehicleMapper.toDTO(vehicle))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle with id: " + vehicleId + " not found"));
        return VehicleMapper.toDTO(vehicle);
    }
}

package com.ktuan28.eco_check.mapper;

import com.ktuan28.eco_check.dto.VehicleDTO;
import com.ktuan28.eco_check.entity.InspectionRecord;
import com.ktuan28.eco_check.entity.User;
import com.ktuan28.eco_check.entity.Vehicle;

public class VehicleMapper {
    // Map Vehicle and InspectionRecord to VehicleDTO
    public static VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        VehicleDTO dto = new VehicleDTO();
        dto.setVehicleId(vehicle.getVehicleId());
        dto.setPlateNumber(vehicle.getPlateNumber());
        dto.setModel(vehicle.getModel());
        dto.setBrand(vehicle.getBrand());

        return dto;
    }

    // Map VehicleDTO to Vehicle (khi nhận request)
    public static Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) {
            return null;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        vehicle.setPlateNumber(dto.getPlateNumber());
        vehicle.setModel(dto.getModel());
        vehicle.setBrand(dto.getBrand());
        return vehicle;
    }
}

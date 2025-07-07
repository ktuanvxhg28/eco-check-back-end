package com.ktuan28.eco_check.mapper;

import com.ktuan28.eco_check.dto.request.VehicleCreateRequest;
import com.ktuan28.eco_check.dto.request.VehicleUpdateRequest;
import com.ktuan28.eco_check.dto.response.VehicleResponse;
import com.ktuan28.eco_check.entity.User;
import com.ktuan28.eco_check.entity.Vehicle;

public class VehicleMapper {

    // Map Vehicle entity => VehicleResponse (trả về FE)
    public static VehicleResponse toResponse(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        VehicleResponse response = new VehicleResponse();
        response.setVehicleId(vehicle.getVehicleId());
        response.setOwnerId(vehicle.getOwner() != null ? vehicle.getOwner().getUserId() : null);
        response.setPlateNumber(vehicle.getPlateNumber());
        response.setModel(vehicle.getModel());
        response.setBrand(vehicle.getBrand());
        response.setManufactureYear(vehicle.getManufactureYear());
        response.setEngineNumber(vehicle.getEngineNumber());
        response.setStatus(vehicle.getStatus());
        return response;
    }

    // Map VehicleCreateRequest => Vehicle entity (khi tạo mới)
    public static Vehicle toEntity(VehicleCreateRequest request, User owner) {
        if (request == null) {
            return null;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setOwner(owner);
        vehicle.setPlateNumber(request.getPlateNumber());
        vehicle.setModel(request.getModel());
        vehicle.setBrand(request.getBrand());
        vehicle.setManufactureYear(request.getManufactureYear());
        vehicle.setEngineNumber(request.getEngineNumber());
        vehicle.setStatus(request.getStatus());
        return vehicle;
    }

    // Áp dụng update request vào entity (khi update)
    public static void updateEntityFromRequest(Vehicle vehicle, VehicleUpdateRequest request) {
        if (vehicle == null || request == null) {
            return;
        }
        vehicle.setModel(request.getModel());
        vehicle.setBrand(request.getBrand());
        vehicle.setManufactureYear(request.getManufactureYear());
        vehicle.setEngineNumber(request.getEngineNumber());
        vehicle.setStatus(request.getStatus());
    }
}


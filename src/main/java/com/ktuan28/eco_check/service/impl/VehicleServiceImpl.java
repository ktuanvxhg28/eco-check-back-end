package com.ktuan28.eco_check.service.impl;

import com.ktuan28.eco_check.dto.request.VehicleCreateRequest;
import com.ktuan28.eco_check.dto.request.VehicleUpdateRequest;
import com.ktuan28.eco_check.dto.response.VehicleResponse;
import com.ktuan28.eco_check.entity.User;
import com.ktuan28.eco_check.entity.Vehicle;
import com.ktuan28.eco_check.entity.roleEnums.VehicleEnums;
import com.ktuan28.eco_check.exception.AppException;
import com.ktuan28.eco_check.exception.ErrorCode;
import com.ktuan28.eco_check.mapper.VehicleMapper;
import com.ktuan28.eco_check.repository.UserRepository;
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
    private UserRepository userRepository;

    @Override
    public List<VehicleResponse> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResponse> getVehicleByOwnerId(Long ownerId) {
        List<Vehicle> vehicles = vehicleRepository.findByOwner_UserId(ownerId);
        if (vehicles.isEmpty()) {
            throw new AppException(ErrorCode.NO_VEHICLES_FOR_OWNER);
        }
        return vehicles.stream()
                .map(VehicleMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResponse updateVehicleById(Long vehicleId, VehicleUpdateRequest updateRequest) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new AppException(ErrorCode.VEHICLE_NOT_FOUND));

        // chỉ update những trường cho phép
        VehicleMapper.updateEntityFromRequest(vehicle, updateRequest);

        if (updateRequest.getStatus() == VehicleEnums.BANNED) {
            throw new AppException(ErrorCode.INVALID_VEHICLE_STATUS);
        }

        Vehicle saved = vehicleRepository.save(vehicle);
        return VehicleMapper.toResponse(saved);
    }

    @Override
    public VehicleResponse createVehicle(Long ownerId, VehicleCreateRequest request) {
        if (vehicleRepository.existsVehicleByPlateNumber(request.getPlateNumber())) {
            throw new AppException(ErrorCode.VEHICLE_ALREADY_EXISTS);
        }

        User user = userRepository.findById(ownerId)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        Vehicle vehicle = VehicleMapper.toEntity(request, user);
        Vehicle saved = vehicleRepository.save(vehicle);

        return VehicleMapper.toResponse(saved);
    }

}

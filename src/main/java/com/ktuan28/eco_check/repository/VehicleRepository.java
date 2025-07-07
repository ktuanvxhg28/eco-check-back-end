package com.ktuan28.eco_check.repository;

import com.ktuan28.eco_check.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
     List<Vehicle> findByOwner_UserId(Long ownerUserId);


     Boolean existsVehicleByPlateNumber(String plateNumber);
}

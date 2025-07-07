package com.ktuan28.eco_check.entity;

import com.ktuan28.eco_check.entity.roleEnums.VehicleEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles", uniqueConstraints = @UniqueConstraint(columnNames = "plate_number"))
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VehicleID")
    private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    private User owner;

    @Column(name = "PlateNumber", nullable = false, unique = true)
    private String plateNumber;

    @Column(name = "Brand", nullable = false)
    private String brand;

    @Column(name = "Model", nullable = false)
    private String model;

    @Column(name = "ManufactureYear", nullable = false)
    private Integer manufactureYear;

    @Column(name = "EngineNumber", nullable = false)
    private String engineNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private VehicleEnums status;
}

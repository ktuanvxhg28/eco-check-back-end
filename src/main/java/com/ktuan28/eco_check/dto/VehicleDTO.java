package com.ktuan28.eco_check.dto;

import com.ktuan28.eco_check.entity.roleEnums.InspectionResult;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private Long vehicleId;

    @NotBlank(message = "Biển số xe không được để trống")
    @Pattern(
            regexp = "^[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}$",
            message = "Biển số xe không đúng định dạng. Ví dụ: 30A-123.45"
    )
    private String plateNumber;

    @NotBlank(message = "Model xe không được để trống")
    private String model;

    @NotBlank(message = "Brand xe không được để trống")
    private String brand;

}


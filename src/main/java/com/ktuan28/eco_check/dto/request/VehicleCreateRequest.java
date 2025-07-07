package com.ktuan28.eco_check.dto.request;

import com.ktuan28.eco_check.entity.roleEnums.VehicleEnums;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCreateRequest {
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

    @NotNull(message = "Năm sản xuất không được để trống")
    private Integer manufactureYear;

    @NotBlank(message = "Số động cơ không được để trống")
    private String engineNumber;

    @NotNull(message = "Trạng thái không được để trống")
    private VehicleEnums status;
}

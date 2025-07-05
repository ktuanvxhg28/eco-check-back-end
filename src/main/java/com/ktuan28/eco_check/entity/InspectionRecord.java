package com.ktuan28.eco_check.entity;

import com.ktuan28.eco_check.entity.roleEnums.InspectionResult;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inspectionrecords")
public class InspectionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecordID")
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "VehicleID", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "StationID", nullable = false)
    private InspectionStation station;

    @ManyToOne
    @JoinColumn(name = "InspectorID")
    private User inspector;  // role = INSPECTOR

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "InspectionDate", nullable = false)
    private Date inspectionDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "NextInspectionDate")
    private Date nextInspectionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Result", nullable = false)
    private InspectionResult result;

    @Column(name = "CO2Emission")
    private Double co2Emission;

    @Column(name = "HCEmission")
    private Double hcEmission;

    @Column(name = "Comments")
    private String comments;
}

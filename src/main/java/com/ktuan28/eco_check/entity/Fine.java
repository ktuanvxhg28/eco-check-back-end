package com.ktuan28.eco_check.entity;

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
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FineID")
    private Long fineId;

    @ManyToOne
    @JoinColumn(name = "VehicleID", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "OwnerID", nullable = false)
    private User owner;

    @ManyToOne
    @JoinColumn(name = "PoliceOfficerID", nullable = false)
    private User policeOfficer;

    @Column(name = "Reason", nullable = false)
    private String reason;

    @Column(name = "Amount", nullable = false)
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate", nullable = false)
    private Date createdDate;

    @Column(name = "IsPaid", nullable = false)
    private Boolean isPaid = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PaymentDate")
    private Date paymentDate;

    @Column(name = "Notes")
    private String notes;
}

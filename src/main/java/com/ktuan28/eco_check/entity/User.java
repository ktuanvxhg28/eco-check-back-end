package com.ktuan28.eco_check.entity;


import com.ktuan28.eco_check.entity.roleEnums.ProviderClass;
import com.ktuan28.eco_check.entity.roleEnums.RoleEnums;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "FullName", nullable = false)
    private String fullName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;  // BCrypt hashed

    @Enumerated(EnumType.STRING)
    @Column(name = "Role", nullable = false)
    private RoleEnums role;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Avatar")
    private String avatar;

    @Enumerated(EnumType.STRING)
    @Column(name = "Provider")
    private ProviderClass provider;

    @ManyToOne
    @JoinColumn(name = "StationID")
    private InspectionStation inspectionStation;
}
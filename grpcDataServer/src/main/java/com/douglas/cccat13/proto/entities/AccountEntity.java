package com.douglas.cccat13.proto.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
public class AccountEntity {

    @Id
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false,name = "car_plate")
    private String carPlate;
    @Column(nullable = false,name = "is_passenger")
    private boolean isPassenger;
    @Column(nullable = false,name = "is_driver")
    private boolean isDriver;
    @Column(nullable = false)
    private Date date;
    @Column(nullable = false,name = "is_verified")
    private boolean isVerified;
    @Column(nullable = false,name = "verification_code")
    private UUID verificationCode;


}
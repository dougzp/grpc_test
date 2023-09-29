package com.douglas.cccat13.tos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountTos {


        private UUID id;
        private String name;
        private String email;
        private String cpf;
        private String carPlate;
        private boolean isPassenger;
        private boolean isDriver;
        private boolean isVerified;
        private UUID verificationCode;
}

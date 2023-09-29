package com.douglas.cccat13.proto.service;


import com.douglas.cccat13.proto.definition.AccountGrpc;
import com.douglas.cccat13.proto.definition.AccountRequest;
import com.douglas.cccat13.proto.definition.AccountResponse;
import com.douglas.cccat13.proto.entities.AccountEntity;
import com.douglas.cccat13.proto.repository.AccountRepository;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AccountGrpcImpl extends AccountGrpc.AccountImplBase {

    private final AccountRepository accountRepository;

    @Override
    public void createAccount(AccountRequest request, StreamObserver<AccountResponse> responseObserver) {

        AccountEntity accountEntity = AccountEntity.builder()
                .id(UUID.randomUUID())
                .cpf("84029609015")
                .email("email@email.com")
                .name("name")
                .isDriver(true)
                .isPassenger(false)
                .verificationCode(UUID.randomUUID())
                .carPlate("AAA1234")
                .date(new Date())
                .build();
        this.accountRepository.save(accountEntity);
        AccountResponse response = AccountResponse.newBuilder().setAccountId(UUID.randomUUID().toString()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
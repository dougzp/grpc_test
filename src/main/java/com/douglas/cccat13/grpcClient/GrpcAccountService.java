package com.douglas.cccat13.grpcClient;


import com.douglas.cccat13.proto.definition.AccountGrpc;
import com.douglas.cccat13.proto.definition.AccountRequest;
import com.douglas.cccat13.proto.definition.AccountResponse;
import com.douglas.cccat13.tos.AccountTos;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GrpcAccountService {

    private final AccountGrpc.AccountBlockingStub accountStub;
    public GrpcAccountService(AccountGrpc.AccountBlockingStub accountStub) {
        this.accountStub = accountStub;
    }

    public String createAccount(final AccountTos accountTos) {
        try {
            AccountRequest request = AccountRequest.newBuilder().setAccountId(UUID.randomUUID().toString())
                    .setName(accountTos.getName())
                    .setEmail(accountTos.getEmail())
                    .setCpf(accountTos.getCpf())
                    .setCarPlate(accountTos.getCarPlate())
                    .setDate(Timestamp.newBuilder().build())
                    .setIsDriver(accountTos.isDriver())
                    .setIsPassenger(accountTos.isPassenger())
                    .setIsVerified(accountTos.isVerified())
                    .setVerificationCode(accountTos.getVerificationCode().toString())
                    .build();
            final AccountResponse response = this.accountStub.createAccount(request);
            return response.getAccountId();

        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }

    }

}

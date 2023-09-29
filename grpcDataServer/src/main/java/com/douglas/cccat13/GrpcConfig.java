package com.douglas.cccat13;

import com.douglas.cccat13.proto.repository.AccountRepository;
import com.douglas.cccat13.proto.service.AccountGrpcImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {
    private final AccountRepository accountRepository;

    @Autowired
    public GrpcConfig(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public Server grpcServer() {
        return ServerBuilder.forPort(9090)
                .addService(new AccountGrpcImpl(accountRepository))
                .build();
    }
}
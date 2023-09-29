package com.douglas.cccat13.application;

import com.douglas.cccat13.api.controller.AccountController;
import com.douglas.cccat13.proto.definition.AccountGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

@Configuration
public class Config {


    @Value("${grpc.server.address:localhost}")
    private String grpcServerAddress;

    @Value("${grpc.server.port:9090}")
    private int grpcPort;

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress(grpcServerAddress, grpcPort)
                .usePlaintext()  // Omit this line if using TLS/SSL.
                .build();
    }

    @Bean
    public AccountGrpc.AccountBlockingStub accountBlockingStub(ManagedChannel channel) {
        return AccountGrpc.newBlockingStub(channel);
    }

    @PreDestroy
    public void shutdownChannel() {
        if (this.managedChannel() != null && !this.managedChannel().isShutdown()) {
            this.managedChannel().shutdown();
        }
    }


}

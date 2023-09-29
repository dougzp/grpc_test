package com.douglas.cccat13.proto.repository;

import io.grpc.Server;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestConfig {
    @Bean
    public Server grpcServer() {
        return mock(Server.class);
    }
}
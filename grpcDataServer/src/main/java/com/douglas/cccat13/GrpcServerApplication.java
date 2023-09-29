package com.douglas.cccat13;

import io.grpc.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GrpcServerApplication implements ApplicationRunner {

    @Autowired
    private Server grpcServer;
    public static void main(String[] args) {
        SpringApplication.run(GrpcServerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        grpcServer.awaitTermination();
    }
}
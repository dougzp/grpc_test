package com.douglas.cccat13.proto.repository;

import com.douglas.cccat13.proto.entities.AccountEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestConfig.class)
class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;
    private final UUID accountId=UUID.randomUUID();
    @BeforeEach
    void setUp(){
        AccountEntity account = AccountEntity.builder()
                .id(accountId)
                .name("douglas")
                .email("douglas@email.com")
                .isPassenger(false)
                .isDriver(true)
                .isVerified(true)
                .verificationCode(UUID.randomUUID())
                .carPlate("AAA1234")
                .date(new Date())
                .cpf("45698765412").build();
        accountRepository.save(account);

    }

    @AfterEach
    void setDown(){

        accountRepository.deleteById(accountId);

    }

    @Test
    void shouldReturnAccountForExistingEmail(){
        //Given
        String emailToFind =  "douglas@email.com";
        //When
        Optional<AccountEntity> account = accountRepository.findByEmail(emailToFind)
                .flatMap(accounts -> accounts.stream().findFirst());

        AccountEntity accountEntity = account.orElse(new AccountEntity());

        assertEquals(accountEntity.getEmail(), emailToFind);




    }


}
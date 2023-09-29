package com.douglas.cccat13.proto.repository;



import com.douglas.cccat13.proto.entities.AccountEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends ListCrudRepository<AccountEntity, UUID> {


    Optional<List<AccountEntity>> findByEmail(String email);

}
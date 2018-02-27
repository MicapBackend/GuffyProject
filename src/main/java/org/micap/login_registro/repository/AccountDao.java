package org.micap.login_registro.repository;

import org.micap.login_registro.entity.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountDao extends ReactiveMongoRepository<Account,String> {
}

package org.micap.login_registro.repository;

import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

public interface AccountDao extends ReactiveMongoRepository<Account,String> {
}

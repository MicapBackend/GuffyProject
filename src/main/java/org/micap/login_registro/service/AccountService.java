package org.micap.login_registro.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.User;
import org.micap.login_registro.repository.AccountDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@AllArgsConstructor
@NoArgsConstructor
@Service
public class AccountService {
    @Autowired
    private AccountDaoImp accountDaoImp;

    public Mono<ServerResponse> UserOfAccount(ServerRequest req){
        return ok().body( accountDaoImp.UserOfAccount(req.bodyToMono(Account.class).block()),User.class);
    }

    public Mono<ServerResponse> getAccounts(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),Account.class);
    }


    public Mono<ServerResponse> createAccount(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),Account.class);
    }

    public Mono<ServerResponse> getAccount(ServerRequest Req){
        return ok().body(accountDaoImp.accountDao.findById(Req.pathVariable("id")), Account.class);
    }


    public Mono<ServerResponse> updateAccount(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),Account.class);
    }

    public Mono<ServerResponse> deleteAccount(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),Account.class);
    }
}

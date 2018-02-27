package org.micap.login_registro.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.User;
import org.micap.login_registro.repository.AccountDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AccountService {

    @Autowired
    private AccountDaoImp accountDaoImp;


    public Mono<ServerResponse> getUsers(ServerRequest serverRequest){
        return ok().body(accountDaoImp.accountDao.findAll().map(e->{
            e.set_id(e.get_id().toString());
            e.setAudit(null);
            return e;
        }),Account.class);
    }
    public Mono<ServerResponse> getUser(ServerRequest serverRequest){
        Account account =accountDaoImp.accountDao.findById(serverRequest.pathVariable("id")).block();
        account.set_id(account.get_id().toString());
        account.setAudit(null);
        return ok().body(Mono.just(account),Account.class);
    }/*
    public Mono<ServerResponse> createUser(ServerRequest serverRequest){
        User user =serverRequest.bodyToMono(User.class).block();
        user.set_id(new ObjectId());
        user.setDateCreate(new Date());
        user.setDateModify(new Date());
        user.setUserCreated(user.get_id());
        user.setUserModify(user.get_id());
        return ok().body(accountDaoImp.userDao.insert(user),User.class);
    }*/

    /*
    public Mono<ServerResponse> UserOfAccount(ServerRequest req){
        return ok().body( accountDaoImp.UserOfAccount(req.bodyToMono(User.class).block()),User.class);
    }

    public Mono<ServerResponse> createAccount(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),User.class);
    }
    */

}

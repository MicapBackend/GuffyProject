package org.micap.login_registro.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.Audit;
import org.micap.login_registro.entity.User;
import org.micap.login_registro.repository.AccountDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
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
        return ok().body(accountDaoImp.accountDao.findAll().map(
                account->
                        account
                                .set_id(account.get_id().toString())
                                .setAudit(null)
        ),Account.class);
    }

    public Mono<ServerResponse> getUser(ServerRequest serverRequest){
        /*
        Account account =accountDaoImp.accountDao.findById(serverRequest.pathVariable("id")).block();
        account.set_id(account.get_id().toString());
        account.setAudit(null);
        return ok().body(Mono.just(account),Account.class);
        */
        return accountDaoImp.accountDao.findById(serverRequest.pathVariable("id"))
                        .flatMap(
                                account->ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(fromObject(
                                                account
                                                        .setAudit(null)
                                                        .setIdToString()
                                                )
                                        )
                        )
                        .switchIfEmpty(notFound().build());
    }
    public Mono<ServerResponse> createUser(ServerRequest serverRequest){
/*        Account account =serverRequest.bodyToMono(Account.class).block();
        account.set_id(new ObjectId());
        account.setAudit(new Audit(new Date(),new Date(),account.get_id(),account.get_id()));*/
        return ok().body(accountDaoImp.accountDao.insert(
                serverRequest.bodyToMono(Account.class)
                        .block()
                        .set_id(new ObjectId())
                        .createNewAudit()
        ),Account.class);
    }

    public Mono<ServerResponse> modifyUser(ServerRequest serverRequest){
/*        Account account =serverRequest.bodyToMono(Account.class).block();
        account.set_id(new ObjectId());
        account.setAudit(new Audit(new Date(),new Date(),account.get_id(),account.get_id()));*/
        return ok().body(accountDaoImp.accountDao.save(
                serverRequest.bodyToMono(Account.class)
                        .block()
                        .set_id(new ObjectId())
                        .createNewAudit()
        ),Account.class);
    }
    public Mono<ServerResponse> removeUser(ServerRequest serverRequest){
/*        Account account =serverRequest.bodyToMono(Account.class).block();
        account.set_id(new ObjectId());
        account.setAudit(new Audit(new Date(),new Date(),account.get_id(),account.get_id()));*/
        return accountDaoImp.accountDao.findById(serverRequest.pathVariable("id"))
                .flatMap(
                        account->ok().build(accountDaoImp.accountDao.deleteById(serverRequest.pathVariable("id")))
                )
                .switchIfEmpty(notFound().build());
    }

    /*
    public Mono<ServerResponse> UserOfAccount(ServerRequest req){
        return ok().body( accountDaoImp.UserOfAccount(req.bodyToMono(User.class).block()),User.class);
    }

    public Mono<ServerResponse> createAccount(ServerRequest req){
        return ok().body(accountDaoImp.accountDao.findAll(),User.class);
    }
    */
}

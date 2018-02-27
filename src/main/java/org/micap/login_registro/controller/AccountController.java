package org.micap.login_registro.controller;

import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.User;
import org.micap.login_registro.repository.AccountDaoImp;
import org.micap.login_registro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Service for  Account
 * Create by Warren Stephen Aroni soto
 * Creation Date 24/02/2018
 */
@Configuration
public class AccountController {

    @Autowired
    AccountService accountService;

    @Bean
    RouterFunction<ServerResponse> Routes(AccountDaoImp accountDaoImp) {
        return nest(path("/account"),
                route(
                        GET("/"), Req -> accountService.getAccounts(Req)
                ).andRoute(
                        GET("/{id}"), Req -> ok().body(accountDaoImp.accountDao.findById(Req.pathVariable("id")), Account.class)
                ).andRoute(
                        POST("/"), Req -> ok().body(accountDaoImp.accountDao.insert(Req.bodyToMono(Account.class)), Account.class)
                ).andRoute(
                        POST("/user"), Req -> ok().body(accountDaoImp.UserOfAccount(Req.bodyToMono(Account.class).block()), User.class)
                )
        );
    }
}


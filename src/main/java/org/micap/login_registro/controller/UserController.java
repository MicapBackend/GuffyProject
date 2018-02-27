package org.micap.login_registro.controller;

import org.micap.login_registro.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@Configuration
public class UserController {

    @Bean
    RouterFunction<ServerResponse> Routes(AccountService userService) {
        return nest(path("/user"),
                route(
                        GET("/")        , Req -> userService.getUsers(Req)
                ).andRoute(
                        GET("/{id}")    , Req -> userService.getUser(Req)
                ).andRoute(
                        POST("/")       , Req -> userService.createUser(Req)
                )
        );
    }
}


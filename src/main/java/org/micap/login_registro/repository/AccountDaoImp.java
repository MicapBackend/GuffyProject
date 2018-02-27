package org.micap.login_registro.repository;

import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Account Implementation to Database dto class
 * Create by Warren Stephen Aroni soto
 * Creation Date 24/02/2018
 */
@Service
public class AccountDaoImp {
    @Autowired
    public AccountDao accountDao;

    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;


    public Flux<User> UserOfAccount(Account account){
        System.out.println("-->"+account);
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(Account.class,
                Aggregation.match(where("_id").is(account.get_id()))
                ,Aggregation.project("user")
                ,Aggregation.replaceRoot("user")
                )
                ,"account",User.class);
    }
}

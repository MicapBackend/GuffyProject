package org.micap.login_registro.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@Service
public class AccountDaoImp {
    @Autowired
    public AccountDao accountDao;

    @Autowired
    public ReactiveMongoOperations reactiveMongoOperations;

    /*
    public Flux<User> UserOfAccount(User account){
        return reactiveMongoOperations.aggregate(Aggregation.newAggregation(User.class,
                Aggregation.match(where("_id").is(account.get_id()))
                ,Aggregation.project("user")
                ,Aggregation.replaceRoot("user")
                )
                ,"account",User.class);
        }*/
}

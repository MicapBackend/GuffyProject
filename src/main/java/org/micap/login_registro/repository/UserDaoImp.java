package org.micap.login_registro.repository;


import org.micap.login_registro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 11:23
 */

@Service
public class UserDaoImp {
    @Autowired
    public UserDao userDao;

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

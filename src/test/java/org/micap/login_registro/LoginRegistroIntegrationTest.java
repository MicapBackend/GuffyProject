/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.micap.login_registro;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.micap.login_registro.entity.Account;
import org.micap.login_registro.entity.Audit;
import org.micap.login_registro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration test for {@link ReactiveMongoTemplate}.
 *
 * @author Mark Paluch
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRegistroIntegrationTest {

	@Autowired
    ReactiveMongoTemplate template;

	@Before
	public void setUp() {

		StepVerifier.create(template.dropCollection(Account.class)).verifyComplete();

		List<Account> aux=						Stream.of("warren","Amir","Alici","otro")
				.map(name->
						new Account(
								new ObjectId(),
								name+"_as123@gmail.com",
								"123456",
								name+"xxx",
								new String[]{"user","admi"},
								new Audit(
										new Date(),
										new Date(),
										new ObjectId(),
										new ObjectId()),
								new User(
										name,
										"aroni",
										new Date(),
										"macho")
						))
				.collect(Collectors.toList());
		Account []ac=aux.toArray(new Account[aux.size()]);

		Flux<Account> insertAll = template
				.insertAll(Flux.just(ac).collectList());

		StepVerifier.create(insertAll).expectNextCount(4).verifyComplete();
	}

	/**
	 * This sample performs a count, inserts data and performs a count again using reactive operator chaining. It prints
	 * the two counts ({@code 4} and {@code 6}) to the console.
	 */
	@Test
	public void shouldInsertAndCountData() {

		List<Account> aux=						Stream.of("warren","Amir")
				.map(name->
						new Account(
								new ObjectId(),
								name+"_as123@gmail.com",
								"123456",
								name+"xxx",
								new String[]{"user","admi"},
								new Audit(
										new Date(),
										new Date(),
										new ObjectId(),
										new ObjectId()),
								new User(
										name,
										"aroni",
										new Date(),
										"macho")
						))
				.collect(Collectors.toList());
		Account []ac=aux.toArray(new Account[aux.size()]);

		Mono<Long> count = template.count(new Query(), Account.class) //
				.doOnNext(System.out::println) //
				.thenMany(template.insertAll(Arrays.asList(ac))) //
				.last() //
				.flatMap(v -> template.count(new Query(), Account.class)) //
				.doOnNext(System.out::println);//

		StepVerifier.create(count).expectNext(6L).verifyComplete();
	}

}

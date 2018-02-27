package org.micap.login_registro;

import org.bson.types.ObjectId;
import org.micap.login_registro.entity.User;
import org.micap.login_registro.repository.UserDao;
import org.micap.login_registro.repository.UserDaoImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class LoginRegistroApplication {
	@Bean
	CommandLineRunner demo(UserDao userDao){
		return args->{
			userDao.deleteAll()
					.subscribe(null,null,()->
							Stream.of("warren","Amir","Alici")
									.map(name->
											new User(
													new ObjectId(),
													name+"_as123@gmail.com",
													"123456",
													name+"xxx",
													new String[]{"user","admi"},
													new Date(),
													new Date(),
													new ObjectId(),
													new ObjectId(),
													name,
													"aroni",
													new Date(),
													"macho"
											))
									.forEach(	user->userDao.insert(user).subscribe(System.out::println))
					);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginRegistroApplication.class, args);
	}
}

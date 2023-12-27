package com.birdiebuddy.birdiebuddy;

import com.birdiebuddy.birdiebuddy.entity.User;
import com.birdiebuddy.birdiebuddy.repository.UserRepository;
import com.birdiebuddy.birdiebuddy.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@ContextConfiguration(classes = BirdiebuddyApplication.class)
public class BirdiebuddyApplicationTests {

//	@Autowired
//	UserService userService;
//	@Autowired
//	UserRepository userRepository;

//	@Test
//	public void rollin() throws NoSuchFieldException, IllegalAccessException{
//		User user = new User();
//		String userIdVal = "testUserId";
//		//user.
//		Field userIdField = User.class.getDeclaredField("userId");
//		userIdField.setAccessible(true);
//		userIdField.set(user, userIdVal);
//
//		System.out.println(user.getUserId()+"입니다.");
//
//	}

//	@Test
//	public void user_all() throws Exception{
//		//given
//		User user=new User();
//		user.setUserId("hello");
//
//		//when
//		userRepository.save(user);
//
//		//then
//		List<User> userList = userService.findAll();
////		assertEquals("hello", userList.get(0).getUserId());
//	}


}

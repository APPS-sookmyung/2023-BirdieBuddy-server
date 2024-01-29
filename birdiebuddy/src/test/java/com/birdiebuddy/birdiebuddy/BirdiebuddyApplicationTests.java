package com.birdiebuddy.birdiebuddy;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

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

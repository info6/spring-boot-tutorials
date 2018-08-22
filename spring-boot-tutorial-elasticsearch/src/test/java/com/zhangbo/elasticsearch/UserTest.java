package com.zhangbo.elasticsearch;

import com.zhangbo.elasticsearch.dao.UserRepository;
import com.zhangbo.elasticsearch.document.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void saveUser() {
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setId((long) i);
			user.setUserName("张三" + i);
			user.setUserAddress("北京");
			user.setUserPhone("1888888888");
			userRepository.save(user);
		}
	}

	@Test
	public void findUser() {

		Iterable<User> userList = userRepository.findAll();

		userList.forEach(System.out::println);

	}

	@Test
	public void findUserByLike() {

		User user = userRepository.findByUserNameLike("张三");

		System.out.println(user);
	}

	@Test
	public void deleteUser() {

		System.out.println("删除前数量：" + userRepository.count());

		userRepository.deleteById(1L);

		System.out.println("删除后数量" + userRepository.count());

	}

	@Test
	public void findByPage() {

		Sort sort = Sort.by("id").descending();

		Pageable pageable = PageRequest.of(0, 20, sort);

		Page<User> userPage = userRepository.findAll(pageable);

		System.out.println("总页数：" + userPage.getTotalPages());

		System.out.println("总记录数：" + userPage.getTotalElements());

		List<User> userList = userPage.getContent();

		userList.forEach(System.out::println);

	}

	@Test
	public void updateUser() {

		Optional<User> userOptional = userRepository.findById(1L);
		if (userOptional.isPresent()) {
			System.out.println(userOptional.get());
			User user = userOptional.get();
			user.setUserName("新名字");
			userRepository.save(user);
			System.out.println(user);
		}

	}
}

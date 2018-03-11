package com.priest.spring28minutes.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.priest.spring28minutes.dto.User;

@Repository
public class UserDAO {
	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 0;
	static {
		users.add(new User("Thang", 1, new Date()));
		users.add(new User("Duong", 2, new Date()));
		users.add(new User("Binh", 3, new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(usersCount++);
		}
		users.add(user);
		return user;
	}

	public User findOne(Integer userId) {
		for (User user : users) {
			if (user.getId() == userId) {
				return user;
			}
		}
		return null;
	}

	public User deleteUser(Integer userId) {
		Iterator<User> iterators = users.iterator();
		while (iterators.hasNext()) {
			User user = iterators.next();
			if (user.getId() == userId) {
				iterators.remove();
				return user;
			}
		}
		return null;
	}
}

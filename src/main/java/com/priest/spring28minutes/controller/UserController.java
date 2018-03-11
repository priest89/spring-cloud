package com.priest.spring28minutes.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.priest.spring28minutes.dao.UserDAO;
import com.priest.spring28minutes.dto.User;
import com.priest.spring28minutes.exception.UserException;

@RestController
public class UserController {
	@Autowired
	private UserDAO userDao;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = "/users/{userId}")
	public Resource<User> findUser(@PathVariable("userId") Integer userId) {
		User user = userDao.findOne(userId);
		if (user == null) {
			throw new UserException("Not found user: " + userId);
		}
		ControllerLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllUser());
		Resource<User> resource = new Resource<User>(user);
		resource.add(linkBuilder.withRel("all-users"));
		return resource;
	}

	@DeleteMapping(value = "/users/{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId) {
		User user = userDao.deleteUser(userId);
		if (user == null) {
			throw new UserException("Not found user: " + userId);
		}
	}

	@GetMapping(value = "/users")
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@PostMapping(value = "/users")
	public User createUser(@Valid @RequestBody User user) {
		return userDao.save(user);
	}

	@GetMapping(value = "/hello-message")
	public String getHelloMessage(@RequestHeader(value = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("message.user.hello", null, locale);
	}

}

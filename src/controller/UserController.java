package controller;

import java.util.LinkedList;
import java.util.List;

import model.User;

public class UserController {

	private List<User> userList;

	public UserController() {
		userList = new LinkedList<>();

		userList.add(new User("C Ronaldo", 1990, "cronaldo", "123", 0));
		userList.add(new User("Ly Tieu Long", 1992, "lytieulong", "123", 1));
		userList.add(new User("Steve Job", 1989, "stevejob", "123", 2));
		userList.add(new User("Albert Einstein", 1997, "einstein", "123", 0));
		userList.add(new User("Nikola Tesla", 2000, "tesla", "123", 2));
	}

	public List<User> findAll() {
		return userList;
	}

	public int add(User user) {

		for (User users : userList) {
			if (users.getUsername().equalsIgnoreCase(user.getUsername())) {
				return 2; // username already used
			}
		}

		if (validateForm(user) == 1) { // Add successfully
			userList.add(user);
		}

		return validateForm(user); // Add failed
	}

	public int update(User user, String username) {

		for (int i = 0; i < userList.size(); i++) {
			User curUser = userList.get(i);

			if (!curUser.getUsername().equalsIgnoreCase(username)) {
				continue;
			}

			user.setUsername(username);
			userList.set(i, user);
			return validateForm(user); // Handle update
		}

		return 0; // Not found username
	}

	public int validateForm(User user) {

		if (user.getFullName().trim().equals("")) {
			return 3; // Full name can not null
		}

		if (user.getUsername().trim().equals("")) {
			return 4; // Username can not null
		}

		if (user.getPassword().trim().equals("")) {
			return 5; // Password can not null
		}

		return 1; // true
	}

	public User findByUsername(String username) {
		User result = null;

		for (User user : userList) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				result = user;
			}
		}

		return result;

	}

	public boolean delete(String username) {
		for (User curUser : userList) {
			if (curUser.getUsername().equalsIgnoreCase(username)) {
				userList.remove(curUser);
				return true;
			}
		}
		return false;
	}
}

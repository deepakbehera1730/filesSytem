package Users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Users.entity.User;
import Users.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping()
	public List<User> getAllUser() {
		return userServiceImpl.findAllUser();
	}

	@PostMapping()
	public String addUser(@RequestBody User user) {
		userServiceImpl.addUser(user);
		return "user Added Successfuly";
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userServiceImpl.findUserById(id);
	}

	@PutMapping("/{id}")
	public String updateUser(@RequestBody User user, @PathVariable int id) {
		userServiceImpl.updateUserById(user, id);
		return "User Updated Succesfully";
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		userServiceImpl.delete(id);
		return "User Deleted Succesfully";
	}
}

package Users.service;

import java.util.List;

import Users.entity.User;

public interface UserService {
	public List<User> findAllUser();

	public User addUser(User user);

	public User findUserById(int id);

	public User updateUserById(User user, int id);

	public void delete(int id);

}

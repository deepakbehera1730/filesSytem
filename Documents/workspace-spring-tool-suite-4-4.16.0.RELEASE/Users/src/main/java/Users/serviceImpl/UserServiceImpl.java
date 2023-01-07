package Users.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Users.entity.User;
import Users.repository.UserRepository;
import Users.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUserById(User user, int id) {
		// TODO Auto-generated method stub
		User usser1 = userRepository.findById(id).orElseThrow();
		usser1.setUserName(user.getUserName());

		return userRepository.save(usser1);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}

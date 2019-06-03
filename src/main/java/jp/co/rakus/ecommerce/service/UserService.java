package jp.co.rakus.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;
	
	public List<User> findAll(){
		return userrepository.findAll();
	}
	
	public User save(User user) {
		return userrepository.save(user);
	}
	
	public void deleteById(Integer id) {
		userrepository.deleteById(id);
	}

}
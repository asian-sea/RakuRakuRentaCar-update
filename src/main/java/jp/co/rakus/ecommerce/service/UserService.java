package jp.co.rakus.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.ecommerce.domain.User;
import jp.co.rakus.ecommerce.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;
	
	
	public User findOneByEmailAndPassword(String email, String password){
		return userrepository.findByEmailAndPassword(email, password);
	}
	
	public User findOneByNameAndEmail(String name, String email){
		return userrepository.findByEmailAndPassword(name,email);
	}
	
	public User save(User user) {
		return userrepository.save(user);
	}
	
	public void deleteById(Integer id) {
		userrepository.deleteById(id);
	}

}

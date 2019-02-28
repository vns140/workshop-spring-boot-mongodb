package com.viniciussaraiva.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciussaraiva.workshopmongo.domain.User;
import com.viniciussaraiva.workshopmongo.repository.UserRepository;
import com.viniciussaraiva.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontado");
		}
		return user.get();
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}
}

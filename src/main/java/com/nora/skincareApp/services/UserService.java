package com.nora.skincareApp.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nora.skincareApp.models.LoginUser;
import com.nora.skincareApp.models.User;
import com.nora.skincareApp.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User login(LoginUser user, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(user.getEmail());
		if (potentialUser.isEmpty() || !BCrypt.checkpw(user.getPassword(), potentialUser.get().getPassword())){
			return null;
		}
		return potentialUser.get();
	}
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", null, "An account with this email already exists.");
		}
		if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", null, "Passwords do not match.");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			String hashPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashPW);
			return userRepo.save(newUser);
		}
	}

	public User findById(Long id) {
		Optional <User> potentialUser = userRepo.findById(id);
		if (potentialUser.isEmpty()) {
			return null;
		} else {
			return potentialUser.get();
		}
	}
}

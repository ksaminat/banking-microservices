package com.edu.bankAccount.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edu.bankAccount.model.Balance;
import com.edu.bankAccount.model.User;

@Service
public class BankingAccountService {

	List<User> userStore = null;
	
	public BankingAccountService() {
		userStore = new ArrayList();
		User user = new User(1, "default-user");
		user.setBalance(new Balance(1, 1000));
		createUser(user);
	}
	
	public List<User> getUserDetails(){
		return userStore;
	}
	
	public User getUserDetail(int id) {
		
		Optional<User> user = userStore.parallelStream().filter((u) -> u.getId()==id)
			.findFirst();
		
		if(user.isPresent())
			return user.get();
		
		return null;
	}
	
	public void createUser(User user) {
		userStore.add(user);
	}
	
	public void updateUser(User user) {
		userStore = userStore.stream().filter((u) -> u.getId()!=user.getId())
			.collect(Collectors.toList());
		userStore.add(user);
	}
	
	public User delete(int id) {
		Optional<User> user = userStore.stream().filter((u) -> u.getId()==id)
						.findFirst();
		
		if(user.isPresent()) {
			userStore.remove(user.get());
			return user.get();
		}
		
		return null;
	}
}

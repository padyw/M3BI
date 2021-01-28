package com.pramod.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pramod.entity.User;
import com.pramod.exceptions.UserNotFoundException;
import com.pramod.repository.UserRepository;
import com.pramod.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="User Resource", description="Shows User related resources")
public class UserController {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserService userService;
	

	@ApiOperation(value="Get User by ID")
	@RequestMapping(value="/users/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getSelectedUser(@PathVariable int id) { 
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("Id "+id+" Not found");
		}
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get User by Name")
	@RequestMapping(value="/usersbyname/{name}", method=RequestMethod.GET)
	public ResponseEntity<?> getSelectedUserByName(@PathVariable String name) { 
		Optional<User> user = userRepository.findByName(name);
		if (user == null) {
			throw new UserNotFoundException("Name "+name+" Not found");
		}
//		Optional<Bonus> bonus = bonusRepository.findById(user.get().getBonusId());
//		if(!bonus.isPresent())
//		{
//			throw new BonusNotFoundException("Bonus for User Id "+ user.get().getBonusId() + " Not Found");
//		}
		return new ResponseEntity<>(user.get(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Get details of all User")
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> addUser(@RequestBody User user) {
		User usersaved = userService.saveUser(user);
		
		URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usersaved.getId()).toUri();
		
		return ResponseEntity.created(uriLocation).build();
		
		
	}
}
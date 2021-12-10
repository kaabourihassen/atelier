package iset.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iset.example.dao.UserRepository;
import iset.example.entities.User;

@RestController
public class UserRestService {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	@GetMapping
	public List<User> getUser(){
		return userRepository.findAll();
		}
	
	@RequestMapping(value="/user/{userId}",method = RequestMethod.GET)
    public User getUser(@PathVariable Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	@PostMapping("/user")
	public User AddUser(@RequestBody User c){
    	return userRepository.save(c);
	}
	
	@RequestMapping(value="/user/{userId}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable Integer userId) {
			userRepository.deleteById(userId);
	}
	
	
	@RequestMapping(value="/user/{userId}",method = RequestMethod.PUT)
	public User EditUser(@PathVariable Integer userId, @RequestBody User user){
		return userRepository.save(user);
    }

	
}

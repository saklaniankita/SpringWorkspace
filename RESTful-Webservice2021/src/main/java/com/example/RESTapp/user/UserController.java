package com.example.RESTapp.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/users")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	/**
	 * Using HATEAOS = Hypertext As The Engine Of Application State.
	 * @param id
	 * @return
	 */
	@GetMapping("/users/{id}")
	public EntityModel<User> findUserById(@PathVariable Integer id) {
		User user = userService.findUserById(id);
		if(user == null)
			throw new UserNotFoundException("No user found by id: "+id);
		
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(linkTo.withRel("all-users"));

		return entityModel;
	}
	
	
	@GetMapping("/users/{id}/{name}")
	public User findUserByIdAndName(@PathVariable Integer id, @PathVariable String name) {
		User user = userService.findUserByIdAndName(id, name);
		if(user == null)
			throw new UserNotFoundException("No user found with id: "+id+" and name: "+name);
		return user;
	}
	
	@GetMapping("/usersByName")
	public ResponseEntity<List<User>> findUsersByName(@RequestParam(name = "userName") String name) throws Exception{
		List<User> users = userService.findUsersBySameName(name);
		if(users.isEmpty())
			throw new UserNotFoundException("NO User found by name "+name);
		return ResponseEntity.ok(users);
		//return users;
		
	}

	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User newUser = userService.saveUser(user);
//		return ResponseEntity.ok(newUser);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(newUser.getId()).toUri();
		
         //It will return Http status as CREATED 
		 return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id){
		User deletedUser = userService.deleteById(id);
		if(deletedUser == null)
			throw new UserNotFoundException("User with id "+id+" not found");
		return ResponseEntity.ok(deletedUser);
	}
	
//	@GetMapping("/hello-world-internationalized")
//	public String helloWorldInternationalized(@RequestHeader(name="Accept-language", required = false) Locale locale) {
//		//return "Good Morning";
//		return messageSource.getMessage("good.morning.message", null, locale);
//	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {
		//return "Good Morning";
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}

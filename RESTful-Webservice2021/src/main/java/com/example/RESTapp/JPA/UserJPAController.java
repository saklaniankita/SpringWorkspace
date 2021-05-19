package com.example.RESTapp.JPA;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List; 
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.RESTapp.user.User;
import com.example.RESTapp.user.UserNotFoundException;

@RestController
public class UserJPAController {

	@Autowired
	UserJPARepository userJpaRepository;
	
	
	@Autowired
	PostJPARepository postJPARepository;
	

	@GetMapping("/jpa/users")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public List<JpaUser> getAllUsers() {
		return userJpaRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<JpaUser>> findUserById(@PathVariable int id) {
		Optional<JpaUser> user = userJpaRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("No user found by id: "+id);
		
		EntityModel<Optional<JpaUser>> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(linkTo.withRel("all-users"));

		return entityModel;
	}

	@PostMapping("jpa/users")
	public ResponseEntity<User> saveUser(@RequestBody JpaUser jpaUser) {
		JpaUser newUser = userJpaRepository.save(jpaUser);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(newUser.getId()).toUri();
		
         //It will return Http status as CREATED 
		 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable Integer id){
		userJpaRepository.deleteById(id);	
	}
	
	@GetMapping("/jpa/users/{userId}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int userId) {
		Optional<JpaUser> optionalJpaUser = userJpaRepository.findById(userId);
		if(!optionalJpaUser.isPresent())
			throw new UserNotFoundException("No user found by id: "+userId);
		List<Post> posts = optionalJpaUser.get().getPosts();
		return posts;
	}
	
	@PostMapping("/jpa/users/{userId}/posts")
	public ResponseEntity<Object> updatePost(@PathVariable int userId, @RequestBody Post post) {
		Optional<JpaUser> optionalJpaUser = userJpaRepository.findById(userId);
		if(!optionalJpaUser.isPresent())
			throw new UserNotFoundException("No user found by id: "+userId);
		JpaUser jpaUser = optionalJpaUser.get();
		post.setUser(jpaUser);
		postJPARepository.save(post);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId()).toUri();
				
		         //It will return Http status as CREATED 
				 return ResponseEntity.created(location).build();
		
	}
}

package com.example.RESTapp.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	public static List<User> users = new ArrayList();
	private static int userCount = 3;

	static {
		users.add(new User(1, "Sam", new Date(), "yfy556ryv"));
		users.add(new User(2, "Adam", new Date(), "rteyr45"));
		users.add(new User(3, "Steve", new Date(), "ear@$%hj"));
		users.add(new User(4, "Eves", new Date(), "rsgrs*%D$^"));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUserById(int id) {
		for(User user:users) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}
	
	public User findUserByIdAndName(Integer id, String name) {
		System.out.println("Hey thereeeeeeeeeee");
		for(User user:users) {
			if(user.getId() == id && user.getName().equalsIgnoreCase(name))
				return user;
		}
		return null;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			userCount++;
			user.setId(userCount);
		}
		users.add(user);
		return user;
		
	}

	public List<User> findUsersBySameName(String name) {
		List<User> list = new ArrayList<User>();
		for(User user:users) {
			if(user.getName().equalsIgnoreCase(name))
				list.add(user);
		}
		return list;
	}
	
	public User deleteById(int id) {
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getId() == id) {
				itr.remove();
				return user;
			}	
		}
		return null;
	}

	
}

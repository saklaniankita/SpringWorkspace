package com.example.RESTapp.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostJPARepository extends JpaRepository<Post, Integer>{

}

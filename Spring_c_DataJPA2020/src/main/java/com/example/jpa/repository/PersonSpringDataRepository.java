package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

}

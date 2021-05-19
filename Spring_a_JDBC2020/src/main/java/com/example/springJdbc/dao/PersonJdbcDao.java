package com.example.springJdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.springJdbc.bean.Person;

/**
 * BeanPropertyRowMapper requires a no argument constructor in the bean class. Otherwise throws exception
 * 
 * In case the column names in the database are different from that of the properties of bean class, then we need to
 * implement RowMapper interface. It has been implemented here but it is not required because bean properties and
 * table columns are same
 * 
 * 
 * @author ankitasaklani
 *
 */
@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
		}
		
	}
	
	

	public List<Person> findAll() {
		//return jdbcTemplate.query("select * from person", new PersonRowMapper());
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		String sql = "select * from person where id = "+id;
		return (Person) jdbcTemplate.queryForObject(
				sql, 
				new BeanPropertyRowMapper(Person.class));
	}
	
	
	public List<Map<String, Object>> findByName(String name)
	{
		String sql = "select * from person where name = ?";
		return (List<Map<String, Object>>)jdbcTemplate.queryForList(sql,new Object[] {name});
	}
	

	public int deleteById(int id) {
		String sql = "delete from person where id = ?";
		return jdbcTemplate.update(
				sql,new Object[] {id});
	}
	

	public int deleteByIdandName(int id, String name) {
		String sql = "delete from person where id = ? AND name = ?";
		return jdbcTemplate.update(
				sql,new Object[] {id, name});
	}
	
	public int insert(Person person) {
		String sql = "insert into person(id, name, location, birth_date) values (?, ?, ?, ?)";
		return jdbcTemplate.update(
				sql,new Object[] {person.getId(), person.getName(), person.getLocation(), person.getBirthDate()});
	}
	
	public int update(Person person) {
		String sql = "update person set name = ?, location = ?, birth_date = ? where id = ?";
		return jdbcTemplate.update(
				sql,new Object[] {person.getName(), person.getLocation(), person.getBirthDate(), person.getId()});
	}
	
	
	
}

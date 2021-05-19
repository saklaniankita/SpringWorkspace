package com.example.RESTapp.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringControler {

	@GetMapping("/firstFilter")
	public MappingJacksonValue firstFilter() {
		List<FilteringBean> list = Arrays.asList(new FilteringBean("one", "two", "three", "four"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value3");
		return filteringCode(filter, list);
	}


	@GetMapping("/secondFilter")
	public MappingJacksonValue secondFilter() {

		List<FilteringBean> list = Arrays.asList(new FilteringBean("one", "two", "three", "four"),
				new FilteringBean("five", "six", "seven", "eight"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2");
		return filteringCode(filter, list);
	}
	
	
	private MappingJacksonValue filteringCode(SimpleBeanPropertyFilter filter, List<FilteringBean> list) {		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("myFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
	}


}

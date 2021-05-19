package com.example.springboot.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.springboot.scope.SpringComponentScanApplication;

@Component
public class BinarySearchAlgo {
	
	private Logger LOGGER = LoggerFactory.getLogger(BinarySearchAlgo.class);

	@Autowired
	@Qualifier("quick")
	private SortAlgorithm sortAlgo;
	
	//to understand properties file
	@Value("${external.service.url}")
	private String url;

	//NOT required because we are using @Autowired which does all this internally
//	public BinarySearchAlgo(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}

//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	} 
	

	public int binarySearch(int[] arr, int num) {
	    System.out.println("################"+sortAlgo.sort(new int[] {1,2,3}));
		return 3;
	}
	
	public String getUrl() {
		return url;
	}
}

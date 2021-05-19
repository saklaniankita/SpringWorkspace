package com.candidjava.corebasic5;

import java.io.FileReader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class LoggingServiceImpl implements LoggingService {

	FileReader fr;

	@PostConstruct
	public void initIt() throws Exception {
		System.out.println("Init method after properties are set : ");
	}

	@PreDestroy
	public void cleanUp() throws Exception {
		System.out.println("Spring Container is destroy! Customer clean up");
		if (fr != null) {
			fr.close();
		}
	}

	@Override
	public void logData(String s) {

		System.out.println("log in Log4jLoggingService" + s);

	}

}
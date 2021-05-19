package com.example.springboot.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, 
		proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {

	public JdbcConnection() {
		System.out.println("JdbcConnection Constrcutor");
	}

}

package com.example.springboot.componentscan;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class JdbcComponent {

	public JdbcComponent() {
		System.out.println("JdbcConnection Constrcutor");
	}

}

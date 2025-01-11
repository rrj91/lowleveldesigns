package com.scaler.jpainheritence2;

import com.scaler.jpainheritence2.service.CrudService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Jpainheritance1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Jpainheritance1Application.class, args);
		CrudService crudService = (CrudService) applicationContext.getBean("crudService");
		crudService.doCrudOperations();
	}

}

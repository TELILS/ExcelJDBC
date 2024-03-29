package com.langsin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@MapperScan("com.langsin.mapper")
@SpringBootApplication
public class ExcelJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelJdbcApplication.class, args);
	}

}

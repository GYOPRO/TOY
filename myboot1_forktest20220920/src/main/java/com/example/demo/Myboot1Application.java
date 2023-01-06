package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import community.CommunityDAO;
import member.MemberDAO;


@SpringBootApplication
@ComponentScan //현재 패키지 annotation인식
@ComponentScan(basePackages = "main") 
@ComponentScan(basePackages = "member") 
@ComponentScan(basePackages = "community") 
@ComponentScan(basePackages = "chatt") 


// @Mapper 스캔설정

@MapperScan(basePackageClasses = MemberDAO.class)
@MapperScan(basePackageClasses = CommunityDAO.class)


public class Myboot1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Myboot1Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Myboot1Application.class);
	}

}

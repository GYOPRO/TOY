package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import comment.CommentDAO;
import community.CommunityDAO;
import member.MemberDAO;
import report.ReportDAO;


@SpringBootApplication
@ComponentScan //현재 패키지 annotation인식
@ComponentScan(basePackages = "controller") 
@ComponentScan(basePackages = "member")
@ComponentScan(basePackages = "community")
@ComponentScan(basePackages = "comment")
@ComponentScan(basePackages = "pose")
@ComponentScan(basePackages = "object")

@ComponentScan(basePackages = "admin")
@ComponentScan(basePackages = "showroom")
@ComponentScan(basePackages = "product")
@ComponentScan(basePackages = "order")
@ComponentScan(basePackages = "shop")
@ComponentScan(basePackages = "productdetail")
@ComponentScan(basePackages = "cart")
@ComponentScan(basePackages = "pose2")
@ComponentScan(basePackages = "chatbot")
@ComponentScan(basePackages = "cs")
@ComponentScan(basePackages = "reserv")
@ComponentScan(basePackages = "csanswere")
@ComponentScan(basePackages = "review")
@ComponentScan(basePackages = "partner")
@ComponentScan(basePackages = "adproduct")
@ComponentScan(basePackages = "report")

// @Mapper 스캔설정
@MapperScan(basePackageClasses = MemberDAO.class)
@MapperScan(basePackageClasses = CommunityDAO.class)
@MapperScan(basePackageClasses = CommentDAO.class)
@MapperScan(basePackageClasses = ReportDAO.class)

@MapperScan(basePackages = "shop")
@MapperScan(basePackages = "productdetail")
@MapperScan(basePackages = "order")
@MapperScan(basePackages = "cart")
@MapperScan(basePackages = "reserv")
@MapperScan(basePackages = "pose2")
@MapperScan(basePackages = "partner")

public class Myboot1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Myboot1Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Myboot1Application.class);
	}

}

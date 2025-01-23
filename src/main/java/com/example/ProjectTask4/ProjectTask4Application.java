package com.example.ProjectTask4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProjectTask4Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTask4Application.class, args);
	}
	//main page
	@GetMapping(path = "/")
	public String index(Model model) {
		return "index";
	}
}
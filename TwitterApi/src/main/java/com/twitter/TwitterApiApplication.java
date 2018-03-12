package com.twitter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.jsf.FacesContextUtils;

@SpringBootApplication
@ComponentScan("com.twitter")
@EntityScan("com.twitter.domain")
public class TwitterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApiApplication.class, args);
	}
}

package com.example.springauthapp;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.springauthapp.model.User;
import com.example.springauthapp.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springauthapp.service.UserService;

@SpringBootApplication
public class JwtAuthServiceApp implements CommandLineRunner {
 
  @Autowired
  private UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(JwtAuthServiceApp.class, args);
  }

  @Override
  public void run(String... params) throws Exception {
    User admin = new User();
    admin.setUsername("admin");
    admin.setPassword("admin");
    admin.setEmail("admin@email.com");
    admin.setAppUserRoles(new ArrayList<UserRole>(Arrays.asList(UserRole.ROLE_ADMIN)));

    userService.signup(admin);
  }

}

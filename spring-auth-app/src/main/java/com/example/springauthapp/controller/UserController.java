package com.example.springauthapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.springauthapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springauthapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;
  
  @GetMapping("/")
  public String home() {
	  return "Welcome Home";
  }
  
  @GetMapping("/all")
  public List<User> getAllUsers() {
	  return userService.getAllUsers();
  }

  @PostMapping("/signin")
  public String login(@RequestParam String username, @RequestParam String password) {
    return userService.signin(username, password);
  }

  @PostMapping("/signup")
  public String signup(@RequestBody User user) {
    return userService.signup(user);
  }

  @DeleteMapping(value = "/{username}")
  public String delete(@PathVariable String username) {
    userService.delete(username);
    return username;
  }

  @GetMapping(value = "/{username}")
  public User search(@PathVariable String username) {
    return userService.search(username);
  }

  @GetMapping(value = "/me")
  public User whoami(HttpServletRequest req) {
    return userService.whoami(req);
  }

  @GetMapping("/refresh")
  public String refresh(HttpServletRequest req) {
    return userService.refresh(req.getRemoteUser());
  }

}

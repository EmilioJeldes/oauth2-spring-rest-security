package com.ewebs.controller;

import com.ewebs.command.UserCommand;
import com.ewebs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Properties;

@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {this.userService = userService;}

    @RequestMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/details")
    public Object getUserDetails(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object credentials = authentication.getCredentials();
        return credentials;
    }

    @GetMapping("/salute")
    public Properties sayHi() {
        Properties properties = new Properties();
        properties.setProperty("Message", "hi");
        return properties;
    }

    @GetMapping("/user")
    public UserCommand getPrincipal(Principal principal) {
        UserCommand userCommand = userService.saveUserCommand(principal);
        return userCommand;
    }

}

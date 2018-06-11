package com.ewebs.controller;

import com.ewebs.command.UserCommand;
import com.ewebs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;
import java.util.Properties;

@RestController
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserCommand getPrincipal(Principal principal) {
        UserCommand userCommand = userService.saveUserCommand(principal);
        return userCommand;
    }

    @RequestMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/details")
    public Object getUserDetails(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getAuthorities();
    }

    @GetMapping("/salute")
    public Properties sayHi() {
        Properties properties = new Properties();
        properties.setProperty("Message", "hi");
        return properties;
    }

    @GetMapping("/test")
    public UserCommand getTestingResoults(Principal principal) {
        OAuth2Authentication source = (OAuth2Authentication) principal;
        Authentication userAuthentication = source.getUserAuthentication();
        Map<String, Object> userDetail = (Map<String, Object>) userAuthentication.getDetails();
        UserCommand user = new UserCommand();
        user.setImageUrl((String) userDetail.get("picture"));
        user.setEmail((String) userDetail.get("email"));
        user.setId((String) userDetail.get("id"));
        user.setLastName((String) userDetail.get("family_name"));
        user.setName((String) userDetail.get("given_name"));
        return user;
    }

}

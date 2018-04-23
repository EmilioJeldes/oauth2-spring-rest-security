package com.ewebs.service;

import com.ewebs.command.UserCommand;

import java.security.Principal;

public interface UserService {

    UserCommand saveUserCommand(Principal details);
}

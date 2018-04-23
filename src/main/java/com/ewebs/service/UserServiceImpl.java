package com.ewebs.service;

import com.ewebs.command.UserCommand;
import com.ewebs.converter.RequestToUserCommand;
import com.ewebs.converter.UserCommandToUser;
import com.ewebs.converter.UserToUserCommand;
import com.ewebs.domain.User;
import com.ewebs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {

    private RequestToUserCommand requestToUserCommand;
    private UserCommandToUser userCommandToUser;
    private UserToUserCommand userToUserCommand;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(RequestToUserCommand requestToUserCommand, UserCommandToUser userCommandToUser, UserToUserCommand
            userToUserCommand, UserRepository userRepository) {
        this.requestToUserCommand = requestToUserCommand;
        this.userCommandToUser = userCommandToUser;
        this.userToUserCommand = userToUserCommand;
        this.userRepository = userRepository;
    }

    @Override
    public UserCommand saveUserCommand(Principal details) {
        UserCommand requestUserCommand = requestToUserCommand.convert(details);
        User detachedUser = userCommandToUser.convert(requestUserCommand);

        User savedUser = userRepository.save(detachedUser);

        return userToUserCommand.convert(savedUser);
    }
}

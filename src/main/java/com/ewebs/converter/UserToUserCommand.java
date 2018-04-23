package com.ewebs.converter;

import com.ewebs.command.UserCommand;
import com.ewebs.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User, UserCommand> {

    @Override
    public UserCommand convert(User source) {
        if (source == null) {
            return null;
        }

        UserCommand userCommand = new UserCommand();
        userCommand.setName(source.getName());
        userCommand.setId(source.getId());
        userCommand.setEmail(source.getEmail());
        userCommand.setLastName(source.getLastName());

        return userCommand;
    }
}

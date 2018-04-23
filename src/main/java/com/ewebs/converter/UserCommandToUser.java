package com.ewebs.converter;

import com.ewebs.command.UserCommand;
import com.ewebs.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    @Override
    public User convert(UserCommand source) {
        if (source == null) {
            return null;
        }

        User user = new User();
        user.setEmail(source.getEmail());
        user.setId(source.getId());
        user.setName(source.getName());
        user.setLastName(source.getLastName());

        return user;
    }
}

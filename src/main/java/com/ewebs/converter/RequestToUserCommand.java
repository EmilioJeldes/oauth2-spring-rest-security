package com.ewebs.converter;

import com.ewebs.command.UserCommand;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Map;

@Component
public class RequestToUserCommand implements Converter<Principal, UserCommand> {

    @Override
    public UserCommand convert(Principal source) {
        if (source == null) {
            return null;
        }

        Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) source).getUserAuthentication().getDetails();

        UserCommand userCommand = new UserCommand();
        userCommand.setName((String) details.get("given_name"));
        userCommand.setLastName((String) details.get("family_name"));
        userCommand.setEmail((String) details.get("email"));
        userCommand.setImageUrl((String) details.get("picture"));
        userCommand.setGender((String) details.get("gender"));
        userCommand.setLanguage((String) details.get("locale"));
        userCommand.setId(source.getName());

        return userCommand;
    }
}

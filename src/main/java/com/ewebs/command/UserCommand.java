package com.ewebs.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {

    private String id;
    private String email;
    private String name;
    private String lastName;
}

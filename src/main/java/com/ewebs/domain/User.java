package com.ewebs.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String email;
    private String name;
    private String lastName;
    private String imageUrl;
    private String gender;
    private String language;

}

package ru.project.accountsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Admin on 20.05.2019.
 */
@Getter
@Setter
public class TokenDTO implements Serializable {

    public TokenDTO(){};

    private String token;
}

package ru.project.accountsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Admin on 12.05.2019.
 */
@Getter
@Setter
public class CredentialsDTO implements Serializable {
    private String login;
    private String password;
}

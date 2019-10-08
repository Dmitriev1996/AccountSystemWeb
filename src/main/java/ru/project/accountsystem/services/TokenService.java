package ru.project.accountsystem.services;

import java.util.Map;

/**
 * Created by Admin on 05.05.2019.
 */
public interface TokenService {
    String permanent(Map<String, String> attributes);
    String expiring(Map<String, String> attributes);
    Map<String, String> untrusted(String token);
    Map<String, String> verify(String token);
}

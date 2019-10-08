package ru.project.accountsystem.security.config.security.utils;

import com.google.common.collect.ImmutableList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Admin on 10.05.2019.
 */
public class CookieUtil {

    private static final String AUTHORIZATION = "Authorization";

    public static String findTokenByCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token="";
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(AUTHORIZATION)) {
                token = cookie.getValue();
            }
        }
        try {
            return java.net.URLDecoder.decode(token, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}

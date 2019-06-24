package com.blame.li.user.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by li
 * 2019/6/25 0:00
 */
public class CookieUtil {

    public static void setCookie(HttpServletResponse response,
                                 String name,
                                 String value,
                                 int maxAge){
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request,
                                 String name){
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}

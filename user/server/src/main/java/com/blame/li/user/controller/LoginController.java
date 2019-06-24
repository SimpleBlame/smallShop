package com.blame.li.user.controller;

import com.blame.li.user.constant.CookieConstant;
import com.blame.li.user.constant.RedisConstant;
import com.blame.li.user.dataobject.UserInfo;
import com.blame.li.user.enums.ResultEnum;
import com.blame.li.user.enums.RoleEnum;
import com.blame.li.user.service.UserService;
import com.blame.li.user.utils.CookieUtil;
import com.blame.li.user.utils.ResultVOUtil;
import com.blame.li.user.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Create by li
 * 2019/6/18 23:07
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 买家登陆
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid")String openid,
                          HttpServletResponse response){
        //1. openid和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2. 判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_FAIL);
        }
        //3. cookie里设置openid=abc
        CookieUtil.setCookie(response, CookieConstant.OPENID, openid, CookieConstant.expire);
        return ResultVOUtil.success();
    }

    /**
     * 卖家登陆
     * @param openid
     * @param response
     * @return
     */
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid")String openid,
                           HttpServletResponse response,
                           HttpServletRequest request){
        // 判断是否登陆过
        Cookie cookie = CookieUtil.getCookie(request, CookieConstant.TOKEN);
        if (cookie != null &&
                !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLTE,cookie.getValue())))){
            return ResultVOUtil.success();
        }

        //1. openid和数据库里的数据匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2. 判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_FAIL);
        }
        //3. redis设置key=uuid,value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLTE,token),
                openid,
                expire,
                TimeUnit.SECONDS);

        //4. cookie里设置openid=xyz
        CookieUtil.setCookie(response, CookieConstant.TOKEN, token, CookieConstant.expire);
        return ResultVOUtil.success();
    }


}

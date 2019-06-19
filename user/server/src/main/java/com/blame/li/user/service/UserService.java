package com.blame.li.user.service;

import com.blame.li.user.dataobject.UserInfo;

/**
 * Create by li
 * 2019/6/18 23:00
 */
public interface UserService {

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}

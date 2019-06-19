package com.blame.li.user.service.impl;

import com.blame.li.user.dataobject.UserInfo;
import com.blame.li.user.repository.UserInfoRepository;
import com.blame.li.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by li
 * 2019/6/18 23:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}

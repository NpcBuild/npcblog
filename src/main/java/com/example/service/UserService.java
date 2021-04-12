package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.lang.Result;
import com.example.entity.User;
import com.example.shiro.AccountProfile;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author npcblog
 * @since 2021-04-10
 */
public interface UserService extends IService<User> {

    Result register(User user);

    AccountProfile login(String username, String password);
}

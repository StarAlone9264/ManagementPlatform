package com.deer.managementPlatform.dao;

import com.deer.managementPlatform.entity.User;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/18 14:46
 */
public interface UserMapper {
    /**
     * 用户名查询
     * @param username 用户名
     * @return user
     */
    public User queryByName(String username);


}

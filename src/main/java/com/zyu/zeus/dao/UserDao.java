package com.zyu.zeus.dao;

import com.zyu.zeus.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/6/11 13:37
 */
public interface UserDao extends JpaRepository<User, Integer> {

    /**
     * OpenId查询
     * @param openId
     * @return
     */
    User findByUseOpenid(String openId);

}

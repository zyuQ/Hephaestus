package com.zyu.zeus.mapper;

import com.zyu.zeus.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/6/11 13:38
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @param user
     * @return
     */
    List<User> findUserAll(User user);


    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);
}

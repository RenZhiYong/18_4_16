package com.bdqn.dao;

import com.bdqn.entity.User;

/**
 * @Author: ldw
 * @Date: created in 10:14 2018/3/27
 * @Description:
 */

public interface NewsUserDao {

    /**
     * 通过id查询用户
     * @param id 用户id
     * @return 用户对象
     * @throws Exception
     */
    User getUserById(Integer id) throws Exception;


    /**
     * 通过用户名和密码查询单个用户
     * @param name 用户名
     * @param pwd 密码
     * @return 用户对象
     */
    User getUser(String name, String pwd) throws Exception;

}

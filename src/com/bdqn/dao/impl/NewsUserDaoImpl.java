package com.bdqn.dao.impl;

import com.bdqn.resultHandle.IResultHandler;
import com.bdqn.dao.NewsUserDao;
import com.bdqn.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: ldw
 * @Date: created in 10:14 2018/3/27
 * @Description:
 */

public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {


    @Override
    public User getUserById(Integer id) throws Exception {
        String sql = "select *  from news_users where status=1 and id=?";
        User user = query(sql, new HandleResult(), id);
        return user;
    }

    @Override
    public User getUser(String name, String pwd) throws Exception {
        String sql = "select *  from news_users where status=1 and username=? and password=?";
        User user = query(sql, new HandleResult(), name, pwd);
        return user;
    }



    class HandleResult implements IResultHandler<User> {
        @Override
        public User handleResult(ResultSet rs) throws SQLException {
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setStatus(rs.getInt(3));
                user.setPassword(rs.getString(4));
            }
            return user;
        }
    }
}

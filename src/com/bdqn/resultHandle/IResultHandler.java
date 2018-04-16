package com.bdqn.resultHandle;

/**
 * @Author: ldw
 * @Date: created in 10:56 2018/3/27
 * @Description:
 */

import com.bdqn.entity.User;

import javax.rmi.CORBA.StubDelegate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 处理结果集
 */
public interface IResultHandler<T> {

   T  handleResult(ResultSet rs) throws SQLException;
}

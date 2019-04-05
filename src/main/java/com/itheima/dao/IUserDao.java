package com.itheima.dao;

import com.itheima.domain.User;
import java.util.List;

/**
 * @author LM_Code
 * @create 2019-04-04-18:08
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();
}

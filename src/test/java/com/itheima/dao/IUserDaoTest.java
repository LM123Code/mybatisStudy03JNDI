package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author LM_Code
 * @create 2019-04-04-19:15
 */
public class IUserDaoTest {
    SqlSession sqlSession = null;
    IUserDao userDao = null;
    @Before
    public void before(){
        sqlSession = SqlSessionFactoryUtil.openSession(true);
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void after(){
        SqlSessionFactoryUtil.close(sqlSession);
    }
    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}

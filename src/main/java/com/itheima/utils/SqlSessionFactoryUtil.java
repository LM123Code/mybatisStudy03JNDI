package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LM_Code
 * @create 2019-04-04-18:15
 */
public class SqlSessionFactoryUtil {
    /**
     * 获取SqlSession工厂的方法
     * @return
     */
    public static SqlSessionFactory getFactory(){
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        try{
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sqlSessionFactory;
    }
    /**
     * 通过会话工厂，打开一个会话
     * @return
     */
    public static SqlSession openSession(boolean isAutoCommit){
        SqlSession session = getFactory().openSession(isAutoCommit);
        return session;
    }

    /**
     * 关闭一个会话
     * @param session
     */
    public static void close(SqlSession session){
        session.close();
    }
}

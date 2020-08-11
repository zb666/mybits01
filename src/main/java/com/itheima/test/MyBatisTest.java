package com.itheima.test;

import com.itheima.IAccountDao.IAccountDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) {
        try {
            InputStream inStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = factoryBuilder.build(inStream);
            //工厂模式生产SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            IAccountDao accountDao = sqlSession.getMapper(IAccountDao.class);
            List<User> usersList = accountDao.findAll();
            for (User user : usersList) {
                System.out.println("User: "+user);
            }
            sqlSession.close();
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

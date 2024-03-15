package com.c.mybatis;

import com.c.mybatis.entity.User;
import com.c.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            // 读取mybatis-config.xml
            inputStream = Resources.getResourceAsStream(resource);
            // 解析mybatis-config.xml配置文件，创建sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            // 创建sqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 创建userMapper对象（UserMapper并没有实现类）
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 调用userMapper对象的方法
            User user = userMapper.selectById(1);
            log.info("测试user信息：{}", user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                assert inputStream != null;
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert sqlSession != null;
            sqlSession.close();
        }
    }

}

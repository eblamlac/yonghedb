package com.example.test;

import com.example.dao.DoorMapper;
import com.example.pojo.Door;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    private static SqlSession session1 = null;
    private static SqlSessionFactory factory = null;

    static {
        try {
            //读取mybatis的核心配置文件(mybatis-config.xml)
            InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config2.xml");
            //基于配置信息获取一个sqlSessionFactory工厂对象
            factory = new SqlSessionFactoryBuilder().build(in);
            session1 = factory.openSession(false);//表示自动提交事务
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   @Test
    public void testFindAll(){
        DoorMapper mapper =session1.getMapper(DoorMapper.class);
        List<Door> list =mapper.findAll();
        for(Door test : list){
            System.out.println(test.toString());
        }
    }
}

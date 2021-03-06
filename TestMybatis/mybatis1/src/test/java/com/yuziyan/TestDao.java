package com.yuziyan;

import com.yuziyan.dao.UserMapper;
import com.yuziyan.pojo.User;
import com.yuziyan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestDao {

    /**
     * 用于测试：
     */
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println("user = " + user);
    }
}

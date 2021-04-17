package com.luosu.blog.mapper;

import com.luosu.blog.entity.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    //所有的操作都用sqlsession来进行
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate _sqlSession){
        this.sqlSession = _sqlSession;
    }

    @Override
    public List<User> getAllUser() {
        return sqlSession.getMapper(UserMapper.class).getAllUser();
    }

    @Override
    public List<User> findByEmail(String emial){
        return sqlSession.getMapper(UserMapper.class).findByEmail(emial);
    }
}

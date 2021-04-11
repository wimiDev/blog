package com.luosu.blog.mapper;

import com.luosu.blog.entity.UserAddr;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserAddrMapperImpl implements UserAddrMapper{
    //所有的操作都用sqlsession来进行
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate _sqlSession){
        this.sqlSession = _sqlSession;
    }

    @Override
    public List<UserAddr> getAllUserAddr() {
        return sqlSession.getMapper(UserAddrMapper.class).getAllUserAddr();
    }
}

package com.sangsang.jdncsharding.service;

import com.sangsang.jdncsharding.domain.UserEntity;
import com.sangsang.jdncsharding.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    private UserMapper userMapper;

    public List<UserEntity> getUsers() {
        List<UserEntity> users=userMapper.getAll();
        return users;
    }
    //    @Transactional(value="test1TransactionManager",rollbackFor = Exception.class,timeout=36000)  //说明针对Exception异常也进行回滚，如果不标注，则Spring 默认只有抛出 RuntimeException才会回滚事务
    public void updateTransactional(UserEntity user) {
        try{
            userMapper.insert(user);
        }catch(Exception e){
            throw e;   // 事物方法中，如果使用trycatch捕获异常后，需要将异常抛出，否则事物不回滚。
        }

    }

    public List<UserEntity> getUsersByPassword() {
        return    userMapper.getUsersByPassword();
    }

    //测试事务
    @Transactional(rollbackFor = Exception.class)
    public void testtrance(){
        UserEntity user1 = UserEntity.builder().id(1L).nickName("第一条数据11111111").userName("第一条数据11111111").order_id(1L).user_id(1L).build();
        UserEntity user2 = UserEntity.builder().id(1L).nickName("第二条数据22222222222").userName("第二条数据22222222222").order_id(2L).user_id(1L).build();
        UserEntity user3= UserEntity.builder().id(2L).nickName("第三条数据333333333").userName("第三条数据333333333").order_id(1L).user_id(2L).build();
        UserEntity user4 = UserEntity.builder().id(2L).nickName("第四条数据4444444444").userName("第四条数据4444444444").order_id(2L).user_id(2L).build();
        userMapper.insert(user1);
        userMapper.insert(user2);
        userMapper.insert(user3);
        System.out.println(1/0);
        userMapper.insert(user4);
    }


}

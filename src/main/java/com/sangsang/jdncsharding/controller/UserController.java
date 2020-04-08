package com.sangsang.jdncsharding.controller;

import com.sangsang.jdncsharding.domain.UserEntity;
import com.sangsang.jdncsharding.enums.UserSexEnum;
import com.sangsang.jdncsharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userService.getUsers();
        return users;
    }

    @RequestMapping("/password")
    public List<UserEntity> getUsersByPassword(){
        return  userService.getUsersByPassword();
    }



    //测试
    @RequestMapping(value = "insert")
    public String updateTransactional(@RequestParam(value = "id") Long id,
                                      @RequestParam(value = "user_id") Long user_id,
                                      @RequestParam(value = "order_id") Long order_id,
                                      @RequestParam(value = "nickName") String nickName,
                                      @RequestParam(value = "passWord") String passWord,
                                      @RequestParam(value = "userName") String userName
    ) {
        UserEntity user2 = new UserEntity();
        user2.setId(id);
        user2.setUser_id(user_id);
        user2.setOrder_id(order_id);
        user2.setNickName(nickName);
        user2.setPassWord(passWord);
        user2.setUserName(userName);
        user2.setUserSex(UserSexEnum.WOMAN);
        userService.updateTransactional(user2);
        return "test";
    }
}

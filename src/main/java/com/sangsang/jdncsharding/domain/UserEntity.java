package com.sangsang.jdncsharding.domain;
import com.sangsang.jdncsharding.enums.UserSexEnum;
import lombok.Data;
@Data
public class UserEntity  {
    private Long id;
    private Long order_id;
    private Long user_id;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;
}

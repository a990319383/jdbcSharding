package com.sangsang.jdncsharding.mapper;

import com.sangsang.jdncsharding.domain.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> getAll();

    void insert(UserEntity user);

    List<UserEntity> getUsersByPassword();
}

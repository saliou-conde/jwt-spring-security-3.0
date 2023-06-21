package com.alibou.security.auth.util;

import com.alibou.security.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResponseMapper {

    private static ResponseMapper instance;

    private ResponseMapper() {
    }

    public static ResponseMapper getInstance() {
        if(instance == null) {
            instance = new ResponseMapper();
        }
        return instance;
    }

    public UserResponse mapAppUserToAppUserDTO(User appUser) {
        return UserResponse
                .builder()
                .email(appUser.getEmail())
                .firstname(appUser.getFirstname())
                .id(appUser.getId())
                .lastname(appUser.getLastname())
                .role(appUser.getRole())
                .build();
    }

    public List<UserResponse> mapAppUserToAppUserDTO(List<User> appUsers) {
        return appUsers
                .stream()
                .map(this::mapAppUserToAppUserDTO)
                .collect(Collectors.toList());
    }

}

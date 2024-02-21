package com.mywork.oauthsecurity.dto;

import com.mywork.oauthsecurity.document.User;
import com.mywork.oauthsecurity.enums.Role;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private String id;
    private String username;
    private Role role;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
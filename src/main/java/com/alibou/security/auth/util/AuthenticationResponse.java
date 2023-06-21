package com.alibou.security.auth.util;

import com.alibou.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}

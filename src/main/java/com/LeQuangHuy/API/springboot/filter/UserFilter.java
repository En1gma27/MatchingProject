package com.LeQuangHuy.API.springboot.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserFilter extends BaseFilter {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String type;
}

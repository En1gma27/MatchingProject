package com.LeQuangHuy.API.springboot.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectFilter extends BaseFilter {
    private String type;
    private String status;
    private String groupName;
    private Long userId;

}

package com.LeQuangHuy.API.springboot.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DemandFilter extends BaseFilter {
    private Long userId;
    private String type;
    private String description ;
}

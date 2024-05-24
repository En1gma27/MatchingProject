package com.LeQuangHuy.API.springboot.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackFilter extends BaseFilter {
    private Long userId;
    private Long connectId;
    private Integer  rate;
    private String note;
}

package com.LeQuangHuy.API.springboot.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterFilter extends BaseFilter {
    private String characterName;
    private Long userId;

}

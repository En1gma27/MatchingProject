package com.LeQuangHuy.API.springboot.filter;


import com.LeQuangHuy.API.springboot.utils.PageUtils;
import com.LeQuangHuy.API.springboot.utils.ProjectConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseFilter {
    private int limit = ProjectConstants.DEFAULT_LIMIT;
    private int page = ProjectConstants.DEFAULT_PAGE;
    private Long id;
    public Pageable getPageable(){
        return PageUtils.buildPageRequest(this.page, this.limit);
    }
}

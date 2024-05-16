package com.LeQuangHuy.API.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "connects")
public class Connect extends BaseModel {



    @JsonProperty("type") // Xác định tên trường trong JSON trả về
    private String type;

    @JsonProperty("status") // Xác định tên trường trong JSON trả về
    private boolean status;

    @JsonProperty("group_name") // Xác định tên trường trong JSON trả về
    private String groupName;


    @JsonIgnore // Không xuất hiện trong response body
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id1")
    private User user;


    @JsonProperty("user_id2")
    private Long userId2;


    @JsonIgnore
    @OneToMany(mappedBy = "connect", cascade = CascadeType.ALL)
    private List<FeedBack> feedBacks = new ArrayList<>();



}

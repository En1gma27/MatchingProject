package com.LeQuangHuy.API.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedbacks")
public class FeedBack extends BaseModel {


    @JsonIgnore // Không xuất hiện trong response body
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connect_id")
    private Connect connect;

    @JsonProperty("rate") // Xác định tên trường trong JSON trả về
    private Integer  rate;

    @JsonProperty("note") // Xác định tên trường trong JSON trả về
    private String note;

}

package com.LeQuangHuy.API.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "demands")
public class Demand extends  BaseModel {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @JsonProperty("type") // Xác định tên trường trong JSON trả về
    private String  type;

    @JsonProperty("description") // Xác định tên trường trong JSON trả về
    private String description;
}


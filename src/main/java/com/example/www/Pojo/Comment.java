package com.example.www.Pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Integer id;
    private String content;
    private Integer userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss”,timezone = “GMT+8”")
    private String time;
    private Integer pId;
    private Integer originId;
    private Integer areaId;
    private Integer hotelId;
    private Integer restaurantId;
    @TableField(exist = false)//标识此字段不在comment表中
    private String nickname;
    @TableField(exist = false)
    private String avatar;
}

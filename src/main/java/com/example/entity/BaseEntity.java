package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

//忘了初始化基类，导致导航栏无法跳转
@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Date created;
    private Date modified;
}

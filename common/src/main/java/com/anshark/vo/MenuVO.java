package com.anshark.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author GUOYU
 * @Date 2021/5/28
 * @Desc
 */
@Data
public class MenuVO {

    private Integer authorityId;

    private String authorityName;

    private Integer orderNumber;

    private String menuUrl;

    private String menuIcon;

    private LocalDateTime createTime;

    private String authority;

    private Integer checked;

    private LocalDateTime updateTime;

    private Integer isMenu;

    private Integer parentId;



}

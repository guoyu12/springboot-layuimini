package com.anshark.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
@Data
public class UserTreeVO {

    private Integer id;

    private String title;

    private String field;

    private boolean checked = false;

    private boolean spread = false;

    private List<UserTreeVO> children;

}

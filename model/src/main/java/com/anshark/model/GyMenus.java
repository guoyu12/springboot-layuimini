package com.anshark.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author GUOYU
 * @since 2021-05-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GyMenus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 链接
     */
    private String href;

    /**
     * 背景图片
     */
    private String image;

    /**
     * 图标
     */
    private String icon;

    /**
     * 父id
     */
    private Integer parentId;

    private Boolean isDeleted;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    /**
     * 0代表首页1 logo 2目录
     */
    private Integer type;

    /**
     * 打开方式
     */
    private String target;

    private Integer sort;

    @TableField(exist = false)
    private List<GyMenus> child;

    private Integer isMenu;


}

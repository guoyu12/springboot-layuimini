package com.anshark.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author GUOYU
 * @since 2021-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GySysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String cfgTitle;

    /**
     * 名称
     */
    private String cfgName;

    /**
     * 值
     */
    private String cfgValue;

    /**
     * ON表示开启OFF表示关闭
     */
    private String cfgActive;

    /**
     * 描述
     */
    private String cfgDescribe;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;


}

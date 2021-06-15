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
 * @since 2021-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GyDataStatistics implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户总数
     */
    private Integer totalUserCount;

    /**
     * 实时在线人数
     */
    private Integer totalUserOnlineCount;

    /**
     * 浏览数
     */
    private Integer totalBrowseCount;

    /**
     * 当天访问量实时
     */
    private Integer totalBrowseTodayCount;

    private LocalDateTime updateAt;

    private LocalDateTime createAt;

    /**
     * 日在线数
     */
    private Integer totalUserOnlineCountStatistics;


}

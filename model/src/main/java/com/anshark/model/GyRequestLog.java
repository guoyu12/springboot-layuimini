package com.anshark.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author GUOYU
 * @since 2021-05-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GyRequestLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer code;

    private String requestUri;

    /**
     * ip地址
     */
    private String ipAddr;

    private String requestParam;

    private String responseMsg;

    private String responseData;

    /**
     * 错误信息
     */
    private String traceStack;

    private LocalDateTime createAt;


}

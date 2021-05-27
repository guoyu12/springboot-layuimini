package com.anshark.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc MD5加密
 */
public class Md5Utils {

    public static final String SALT = "aaxczmchuwexzniuweh";

    /**
     * md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        return DigestUtils.md5Hex(str + SALT);
    }


}

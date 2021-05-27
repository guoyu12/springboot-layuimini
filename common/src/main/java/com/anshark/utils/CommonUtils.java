package com.anshark.utils;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public class CommonUtils {

    /**
     * 26个大写英文字母 26个小写 10个数字
     */
    public static final String[] random = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};


    /**
     * 产生随机数包含(low , hight)
     *
     * @param low
     * @param high
     * @return
     */
    public static Integer random(int low, int high) {
        if (high < low) {
            int pow = low;
            low = high;
            high = pow;
        }

        if (low == high) {
            return high;
        }
        //差
        Integer random = (int) (Math.random() * (high - low)) + low + (int) (Math.random() * 2);
        return random;
    }

    /**
     * 生成4个图形验证码
     *
     * @return
     */
    public static String verifyCode() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 4; i++) {
            Integer random = random(0, 61);
            sb.append(CommonUtils.random[random]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        verifyCode();
    }


}

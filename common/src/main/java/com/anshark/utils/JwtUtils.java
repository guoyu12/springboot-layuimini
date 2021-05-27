package com.anshark.utils;

import com.anshark.exception.SysException;
import com.anshark.response.ResultState;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public class JwtUtils {


    /**
     * token秘钥
     */
    public static final String SECRET = "aauhbklcisd";
    /**
     * token 过期时间: 7天
     */
    public static final int CALENDAR_FIELD = Calendar.DATE;
    public static final int CALENDAR_INTERVAL = 7;


    /**
     * JWT生成Token.<br/>
     * <p>
     * JWT构成: header, payload, signature
     *
     * @param userId 登录成功后用户user_id, 参数user_id不可传空
     */
    public static String createToken(Integer userId) {

        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(CALENDAR_FIELD, CALENDAR_INTERVAL);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>(10);
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(map)
                .withClaim("user_id", null == userId ? null : userId.toString())
                .withClaim("create_at", System.currentTimeMillis())
                .withIssuedAt(iatDate)
                .withExpiresAt(expiresDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {

            return null;
        }
        return jwt.getClaims();
    }

    /**
     * 根据Token获取user_id
     *
     * @param token
     * @return user_id
     */
    public static Integer getUserId(String token) {
        try {
            Map<String, Claim> claims = verifyToken(token);
            if (claims == null) {
                return null;
            }
            Claim userIdClaim = claims.get("user_id");
            if (null == userIdClaim || StringUtils.isEmpty(userIdClaim.asString())) {
                // token 校验失败, 抛出Token验证非法异常
                throw new SysException(ResultState.SYS_EXIT);
            }
            return Integer.valueOf(userIdClaim.asString());
        } catch (Exception e) {
            throw new SysException(ResultState.SYS_EXIT);
        }

    }
}

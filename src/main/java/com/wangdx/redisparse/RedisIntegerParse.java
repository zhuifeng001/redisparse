package com.wangdx.redisparse;

/**
 * @Author: wangdx
 * @Description:
 * @Date: Created by 上午9:18 2019/3/31
 */
public class RedisIntegerParse implements RedisDataTypeParse {
    public static final String INTEGER_MATCH_REG = ":[1-9][0-9]*\r\n";;
    public static final String INTEGER_PARSE_REG = ":(.*?)\r\n";

    @Override
    public String parse(String str) {
        if(!RegexUtil.match(INTEGER_MATCH_REG, str)){
            return "不能被解析的格式";
        }
        return RegexUtil.parse(INTEGER_PARSE_REG, str, "$1");
    }
}

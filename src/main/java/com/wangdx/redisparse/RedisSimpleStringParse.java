package com.wangdx.redisparse;

/**
 * @Author: wangdx
 * @Description:
 * @Date: Created by 上午9:17 2019/3/31
 */
public class RedisSimpleStringParse implements RedisDataTypeParse {
    public static final String STRING_MATCH_REG = "\\+((?![\r|\n|\r\n|\n\r]).)*\r\n";
    public static final String STRING_PARSE_REG = "\\+(.*?)\r\n";

    @Override
    public String parse(String str) {
        if(!RegexUtil.match(STRING_MATCH_REG, str)){
            return "不能被解析的格式";
        }
        return RegexUtil.parse(STRING_PARSE_REG, str, "$1");
    }
}

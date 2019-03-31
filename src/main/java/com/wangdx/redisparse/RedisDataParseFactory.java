package com.wangdx.redisparse;

/**
 * @Author: wangdx
 * @Description:
 * @Date: Created by 上午9:28 2019/3/31
 */
public class RedisDataParseFactory {

    public RedisDataTypeParse createParser(String str) throws Exception {
        if (str == null || "".equals(str)) {
            throw new Exception("没有找到符合条件的解析器");
        }
        // 检查首字符，判断需要使用的解析器
        switch (str.substring(0, 1)) {
            case "+":
                return new RedisSimpleStringParse();
            case ":":
                return new RedisIntegerParse();
            default:
                throw new Exception("没有找到符合条件的解析器");
        }
    }


}

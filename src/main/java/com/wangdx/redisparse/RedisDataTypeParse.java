package com.wangdx.redisparse;

/**
 * @Author: wangdx
 * @Description:
 * @Date: Created by 上午9:14 2019/3/31
 */
public interface RedisDataTypeParse {
    /**
     * 需要解析的redis协议各数据格式
     * @param str
     * @return
     */
    String parse(String str);
}

package com.wangdx.redisparse;

/**
 * 使用简单工厂模式入口方法
 *
 * @Author: wangdx
 * @Description:
 * @Date: Created by 上午9:06 2019/3/31
 */
public class RedisProtocolParseDemo2 {


    public static void main(String[] args) {
        RedisDataParseFactory redisDataParseFactory = new RedisDataParseFactory();
        try {
            //  data demo1 :123\r\n
            String dataDemo = ":123\r\n";
            RedisDataTypeParse parser = redisDataParseFactory.createParser(dataDemo);
            String result = parser.parse(dataDemo);
            System.out.println(result);

            //  data demo2 +saa\r\n
            dataDemo = "+saa\r\n";
            parser = redisDataParseFactory.createParser(dataDemo);
            result = parser.parse(dataDemo);
            System.out.println(result);

            //  data demo3 错误解析 +saa\r\r\n
            dataDemo = "+saa\r\r\n";
            parser = redisDataParseFactory.createParser(dataDemo);
            result = parser.parse(dataDemo);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

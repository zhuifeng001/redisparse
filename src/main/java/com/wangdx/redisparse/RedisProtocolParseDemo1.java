package com.wangdx.redisparse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @Author: wangdx
 * @Description:
 * @Date: Created by 下午6:29 2019/3/29
 */
public class RedisProtocolParseDemo1 {

    /**
     * 检查是否为简单字符串格式
     */
    private static boolean isSimpleString(String str) {
        String simpleStringReg = "\\+((?![\r|\n|\r\n|\n\r]).)*\r\n";
        return match(simpleStringReg, str);
    }

    /**
     * 检查是否可被解析的数字格式数据
     */
    private static boolean isInteger(String str) {
        String integerReg = ":[1-9][0-9]*\r\n";
        return match(integerReg, str);
    }

    /**
     * 简单字符串转换方法
     * @param str
     * @return
     */
    private static String simpleStringParse(String str) {
        String integerReg1 = "\\+(.*?)\r\n";
        return parse(integerReg1, str, "$1");
    }

    /**
     * 数字转换方法
     * @param str
     * @return
     */
    private static String integerParse(String str) {
        String integerReg1 = ":(.*?)\r\n";
        return parse(integerReg1, str, "$1");
    }


    private static boolean match(String reg, String str) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private static String parse(String reg, String originData, String targetData) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(originData);
        return matcher.replaceAll(targetData);
    }

    public static String parseStr(String str) {
        if (isSimpleString(str)) {
            return simpleStringParse(str);
        }

        if (isInteger(str)) {
            return integerParse(str);
        }

        return "不能解析数据";
    }


    public static void main(String[] args) {

        System.out.println(RedisProtocolParseDemo1.parseStr(":123\r\n"));
        System.out.println(RedisProtocolParseDemo1.parseStr(":afas\r\n"));
    }
}

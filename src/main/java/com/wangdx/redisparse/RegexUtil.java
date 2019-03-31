package com.wangdx.redisparse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wangdx
 * @Description:
 * @Date: Created by 上午9:08 2019/3/31
 */
public class RegexUtil {
    /**
     * 检查字符串是否匹配模式
     * @param regex
     * @param str
     * @return
     */
    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 转换符合模式的字符串
     * @param regex
     * @param originStr
     * @param targetStr
     * @return
     */
    public static String parse(String regex, String originStr, String targetStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(originStr);
        return matcher.replaceAll(targetStr);
    }
}

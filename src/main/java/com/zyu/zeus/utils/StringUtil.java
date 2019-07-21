package com.zyu.zeus.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述
 *
 * @author: zyu
 * @description:
 * @date: 2019/5/25 22:19
 */
public class StringUtil {
    private static String BASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final static String buiPrefix="EXB";
    private final static String floPrefix="EXF";
    private final static String RooPrefix="EXR";
    private final static String bui="00000";
    private final static String flo="000000";
    private final static String roo="00000000";
    private static int BASE_LEN = BASE.length();

    public static boolean isEmpty(final CharSequence cs) {
        return StringUtils.isEmpty(cs);
    }

    public static String toString(InputStream is) {
        try {
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean equals(String s1, String s2) {
        if (s1 == s2) {
            return true;
        }

        if (s1 != null && s1.equals(s2)) {
            return true;
        }

        return false;
    }

    public static boolean equalsIgnoreCase(String s1, String s2) {
        return equals(upperCase(s1), upperCase(s2));
    }

    public static String upperCase(String s) {
        if (s == null) {
            return s;
        }
        return s.toUpperCase();
    }

    public static String lowerCase(String s) {
        if (s == null) {
            return s;
        }
        return s.toLowerCase();
    }

    public static boolean in(String s, String[] targets) {
        for (String target : targets) {
            if (equals(s, target)) {
                return true;
            }
        }
        return false;
    }

    public static String format(String format, Object... args) {
        return String.format(format, args);
    }

    public static String format(String source, Map<String, Object> valueMap) {
        StrSubstitutor strSubstitutor = new StrSubstitutor(valueMap, "${ ", " }");
        return strSubstitutor.replace(source);
    }

    public static String genRandomString(int len) {
        StringBuilder sb = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(BASE.charAt(random.nextInt(BASE_LEN)));
        }

        return sb.toString();
    }

    public static String removeSpace(String s) {
        if (s == null) {
            return null;
        }

        return s.replace(" ", "");
    }

    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
    /**
     *
     * Map转String
     * @param map
     * @return
     */
    public static String getMapToString(Map<String, String[]> map){
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(String.valueOf(map.get(keyArray[i])).trim());
            }
            if(i != keyArray.length-1){
                sb.append(",");
            }
        }
        return sb.toString();
    }
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
    public static String getUUid() {
        return UUID.randomUUID().toString().toLowerCase().replaceAll("-","");
    }

    public static String getBuiNo(String no){

        StringBuffer sb=new StringBuffer();
        sb.append(buiPrefix);
        sb.append(bui.substring(0,bui.length()-no.length() ));
        sb.append(no);
        return sb.toString();
    }
    public static String getFloNo(String no){
        StringBuffer sb=new StringBuffer();
        sb.append(floPrefix);
        sb.append(flo.substring(0,flo.length()-no.length() ));
        sb.append(no);
        return sb.toString();
    }
    public static String getRooNo(String no){
        StringBuffer sb=new StringBuffer();
        sb.append(RooPrefix);
        sb.append(roo.substring(0,roo.length()-no.length() ));
        sb.append(no);
        return sb.toString();
    }

    public  static  void changeValue(Integer noVo){
        noVo=noVo+1;
    }
    public static void main(String[] args){
        Integer noVo=1;
        changeValue(noVo);
        System.out.println(noVo);
    }

}

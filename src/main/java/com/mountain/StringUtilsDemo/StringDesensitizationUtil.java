package com.mountain.StringUtilsDemo;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *     常用的字符串脱敏处理工具类
 * </p>
 * @author mountain
 */
public class StringDesensitizationUtil {
    /**
     * 保留前面几位 比如 姓名 张**
     */
    public static String left(String str,int index) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        String name = StringUtils.left(str, index);
        return StringUtils.rightPad(name, StringUtils.length(str), "*");
    }

    /**
     * 前面保留 index 位明文，后面保留 end 位明文,如：[身份证号] 110****58，前面保留3位明文，后面保留2位明文
     */
    public static String around(String str, int index, int end) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return StringUtils.left(str, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(str, end), StringUtils.length(str), "*"), "***"));
    }


    /**
     * 保留后面几位 如手机号 *******5678
     */
    public static String right(String str,int end) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(str, end), StringUtils.length(str), "*");
    }

    public String newDateFormat(String mDate) throws ParseException {
        Date dateTime = null;
//        int num1 = 19;
//        int num2 = 15;
        if (mDate.length() == 19){
            dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mDate);
        }else if (mDate.length() == 14){
            dateTime = new SimpleDateFormat("yyyyMMddHHmmss").parse(mDate);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        return String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
    }

    public int getLength(String mDate){
        return mDate.length();
    }

    public static void main(String[] args) throws ParseException {
        StringDesensitizationUtil stringDesensitizationUtil = new StringDesensitizationUtil();
//        System.out.print(stringDesensitizationUtil.newDateFormat("2021-07-12 10:29:59") + "\n");
//        System.out.print(stringDesensitizationUtil.newDateFormat("20210712102959" + "\n"));

        System.out.print(stringDesensitizationUtil.newDateFormat("2021-10-12 10:29:59") + "\n");
        System.out.print(stringDesensitizationUtil.newDateFormat("20211012102959") + "\n");
        System.out.print(stringDesensitizationUtil.getLength("20211012102959") + "\n");
        System.out.print(stringDesensitizationUtil.getLength("2021-10-12 10:29:59") + "\n");

//        System.out.print(f1 + "\n");
        String str = "15076439496";
        int s = (int) Math.ceil(str.length() / 4);
        System.out.print(left(str,3) + "\n");
        System.out.print(around(str,3,1) + "\n");
        System.out.print(right(str,3) + "\n");
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.printf(String.valueOf(s) + "\n");
        System.out.printf(String.valueOf(Math.ceil(str.length() / 4)) + "\n");
        System.out.printf(String.valueOf(dateTime) + "\n");
        System.out.printf(dateTime.toString());
    }

}

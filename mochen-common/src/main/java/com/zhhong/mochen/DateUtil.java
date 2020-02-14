package com.zhhong.mochen;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author 董仁亮
 * @date 2020-01-13 12:07
 * @Description:日期操作工具类
 */
public class DateUtil {
    /**
     * 日期格式 年 如2009
     */
    public static final String DATEFORMATYEAR = "yyyy";

    /**
     * 日期格式 年 月  如 2009-02
     */
    public static final String DATEFORMATMONTH = "yyyy-MM";

    /**
     * 日期格式 年 月 日 如2009-02-26
     */
    public static final String DATEFORMATDAY = "yyyy-MM-dd";

    /**
     * 日期格式 年 月 日 时 如2009-02-26 15
     */
    public static final String DATEFORMATHOUR = "yyyy-MM-dd HH";

    /**
     * 日期格式 年 月 日 时 分 如2009-02-26 15:40
     */
    public static final String DATEFORMATMINUTE = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式年 月 日 时 分 秒 如 2009-02-26 15:40:00
     */
    public static final String DATEFORMATSECOND = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式年 月 日 时 分 秒 毫秒 如2009-02-26 15:40:00 110
     */
    public static final String DATEFORMATMILLISECOND = "yyyy-MM-dd HH:mm:ss SSS";


    /**
     * 按指定的格式，把Date转换成String 如date为null,返回null
     *
     * @param date   Date参数
     * @param format 日期格式
     * @return String
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }


    /**
     * 按指定的格式，把string转换成Date 如string为空或null，返回null
     *
     * @param string
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date parase(String string, String format) throws ParseException {
        if (StringUtils.isEmpty(string)) {
            return null;
        }
        return new SimpleDateFormat(format).parse(string);
    }


    /**
     * 取一天的开始时间 精确到秒 如果date为null，返回null
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static String getDayFirstSecond(Date date) {
        if (date == null) {
            return null;
        }
        String str = format(date, DATEFORMATDAY) + " 00:00:00";
        return str;
    }


    /**
     * 获取前几天日期
     *
     * @param strDate 当前日期
     * @param daySUm  天数
     * @return
     * @throws ParseException
     */
    public static Date getYestoday(String strDate, int daySUm) throws ParseException {
        if (null != strDate && strDate.length() > 0) {
            final GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(parase(strDate, DATEFORMATDAY));
            cal.add(Calendar.DAY_OF_MONTH, -daySUm);
            final String str = format(cal.getTime(), DATEFORMATDAY);
            return parase(str, DATEFORMATDAY);
        }
        return null;
    }

    /**
     * 获取后几天日期
     *
     * @param strDate 当前日期
     * @param daySUm  天数
     * @return
     * @throws ParseException
     */
    public static Date getTomorrow(String strDate, int daySUm) throws ParseException {
        if (null != strDate && strDate.length() > 0) {
            final GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(parase(strDate, DATEFORMATDAY));
            cal.add(Calendar.DAY_OF_MONTH, -daySUm);
            final String str = format(cal.getTime(), DATEFORMATDAY);
            return parase(str, DATEFORMATDAY);
        }
        return null;
    }


    /**
     * 当前日期 yyyy-MM-dd
     *
     * @return
     */
    public static String getToday() {
        Calendar ca = Calendar.getInstance();
        String str = format(ca.getTime(), DATEFORMATDAY);
        return str;
    }

    /**
     * 当前日期 yyyy-MM
     *
     * @return
     */
    public static String getTodayMonth() {
        Calendar ca = Calendar.getInstance();
        String str = format(ca.getTime(), DATEFORMATMONTH);
        return str;
    }


    /**
     * 当前日期 yyyy-MM-dd HH:mm
     */
    public static String getMinuteSysDate() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        return format(calendar.getTime(), DATEFORMATMINUTE);
    }

    /**
     * 当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getTodayToSecond() {
        Calendar ca = Calendar.getInstance();
        String str = format(ca.getTime(), DATEFORMATSECOND);
        return str;
    }

}

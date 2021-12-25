package com.astonm.springbootBaseProject.common.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public final class DateUtils {

    private final static Log log = LogFactory.getLog(DateUtils.class);
    private static final int MONTHS_OF_QUARTER = 3;

    private static final String TIME_FORMATE_MONTH = "yyyy-MM";

    /**
     * 日期的格式 精确到年：yyyy
     */
    public static final String DATE_FORMATE_TO_YEAR = "yyyy";

    /**
     * 日期格式 精确到秒 ：yyyyMMddHHmmss
     */
    public static final String DATE_FORMDATE_TO_SECOND = "yyyyMMddHHmmss";

    /**
     * 默认时间格式，精确到秒：
     */
    public static final String DEFAULT_TIME_FORMATE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 年月格式
     */
    public static final String DATE_FORMATE_TO_MONTH = "yyyy-MM";
    /**
     * 默认时间格式，精确到日：
     */
    public static final String DEFAULT_DATE_FORMATE = "yyyy-MM-dd";

    /**
     * 将当前日期按格式转字符串
     *
     * @return
     */
    public static String getCurrentDate() {
        return format(new Date(), DEFAULT_DATE_FORMATE);
    }

    /**
     * 将当前日期按格式转字符串
     *
     * @return
     */
    public static String getCurrentDateTime() {
        return format(new Date(), DEFAULT_TIME_FORMATE);
    }

    /**
     * 日期型按格式转字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public final static String formatDateTime(Date date) {
        return format(date, DEFAULT_TIME_FORMATE);
    }

    public final static String formatDate(Date date) {
        return format(date, DEFAULT_DATE_FORMATE);
    }

    /**
     * 日期型按格式转字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public final static String format(Date date, String pattern) {
        if (null == date || null == pattern)
            return "";
        return new SimpleDateFormat(pattern).format(date);
    }

    public final static Date parseDateTime(String dateStr) {
        return parse(dateStr, DEFAULT_TIME_FORMATE);
    }

    public final static Date parseDate(String dateStr) {
        return parse(dateStr, DEFAULT_DATE_FORMATE);
    }

    public final static Date parseDateSecond(String dateStr) {
        return parse(dateStr, DATE_FORMDATE_TO_SECOND);
    }

    /**
     * 日期型按格式转字符串
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public final static Date parse(String dateStr, String pattern) {
        if (StringUtils.isEmpty(dateStr) || StringUtils.isEmpty(pattern))
            return null;
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse(dateStr);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 将日期类型时间转换为14位数字类型yyyyMMddHHmmss
     */
    public final static long date2Long(Date date) {
        if (date == null)
            return 0l;
        return Long.parseLong(new SimpleDateFormat(DateUtils.DATE_FORMDATE_TO_SECOND).format(date));
    }

    /**
     * 将日期类型时间转换为8位数字类型yyyyMMdd
     */
    public final static int date2Int(Date date) {
        if (date == null)
            return -1;
        return Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(date));
    }

    /**
     * 将14位数字时间转换为yyyy-MM-dd HH:mm:ss String时间
     */
    public final static String ymdhmsFormatS(Long l) {
        if (l == null || l.toString().length() != 14) {
            log.debug("Long date Error: " + l);
            return "";
        }
        String str = l.toString();
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " "
                + str.substring(8, 10) + ":" + str.substring(10, 12) + ":" + str.substring(12, 14);
    }

    /**
     * 将14位数字时间转换为yyyy-MM-dd HH:mm String时间
     */
    public final static String ymdhmFormatS(Long l) {
        if (l == null || l.toString().length() > 14) {
            log.debug("Long date Error: " + l);
            return "";
        }
        String str = l.toString();
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " "
                + str.substring(8, 10) + ":" + str.substring(10, 12);
    }

    /**
     * 将14/8位数字时间转换为yyyy-MM-dd String时间
     */
    public final static String ymdFormatS(Long l) {
        if (l == null || l.toString().length() < 8) {
            log.debug("Long date Error: " + l);
            return "";
        }
        String str = l.toString();
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
    }

    /**
     * 将8位数字时间转换为yyyy-MM-dd HH:mm:ss String时间
     */
    public final static String ymdFormatHMS(Long l) {
        if (l == null || l.toString().length() < 8) {
            log.debug("Long date Error: " + l);
            return "";
        }
        String str = l.toString();
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " "
                + "00:00:00";
    }

    public final static String ymdFormatS(String l) {
        if (l == null || l.toString().length() < 8) {
            log.debug("Long date Error: " + l);
            return "";
        }
        String str = l.toString();
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8);
    }

    /**
     * 将字符串时间转换为14位数字日期yyyy-MM-dd HH:mm:ss Long时间
     */
    public final static Long ymdhmsFormatL(String str) {
        if (str == null || str.length() != 19)
            return null;
        String s =
                str.substring(0, 4) + str.substring(5, 7) + str.substring(8, 10)
                        + str.substring(11, 13) + str.substring(14, 16) + str.substring(17, 19);
        return Long.valueOf(s);
    }

    /**
     * 将yyyy-mm-dd 转化为16位的时间数字
     */
    public final static Long ymdFormatL(String str) {
        if (str == null || str.length() != 10)
            return null;
        StringBuilder stime = new StringBuilder();
        stime.append(str.substring(0, 4)).append(str.substring(5, 7)).append(str.substring(8, 10))
                .append("000000");
        return Long.valueOf(stime.toString());
    }

    /**
     * 将yyyy-mm-dd 转化为16位的时间数字 , 并加上235959
     *
     * @param str
     * @return
     */
    public final static Long ymdFormatLDayEnd(String str) {
        Long time = ymdFormatL(str);
        if (time != null) {
            time = time + 235959;
        }
        return time;
    }

    /**
     * 将yyyymmdd* 格式 取月日 -s 分隔符 08/29
     */
    public static final String mdFormatS(String str) {
        return mdFormatS(str, "/");
    }

    public static final String mdFormatS(String str, String s) {
        if (null == str || str.length() < 8)
            return null;
        return str.substring(4, 6) + s + str.substring(6, 8);
    }

    /**
     * 将日期转成12/28/2011的样式
     *
     * @param str
     * @param s
     * @return
     */
    public static final String mdFormatdmy(String str, String s) {
        if (null == str || str.length() < 8)
            return null;
        return str.substring(4, 6) + s + str.substring(6, 8) + s + str.substring(0, 4);
    }

    /**
     * @param time 当前时间 long
     * @param day 跨越天数
     * @return 跨天后的时间
     */
    public final static Long getLastTime(Long time, int day) {
        String lasttime = DateUtils.ymdhmsFormatS(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(lasttime);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        Date lastdate = now.getTime();
        return date2Long(lastdate);
    }

    /**
     * @param time 当前时间 减去指定的小时
     * @param hour 小时
     * @return 提前到指定小时的时间
     */
    public final static Long getLastTimeReduceHour(Long time, int hour) {
        String lasttime = DateUtils.ymdhmsFormatS(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(lasttime);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) - hour);
        Date lastdate = now.getTime();
        return date2Long(lastdate);
    }

    /**
     * @param time 当前时间 加上指定的小时
     * @param hour 小时
     * @return 提前到指定小时的时间
     */
    public final static Long getLastTimeAddHour(Long time, int hour) {
        String lasttime = DateUtils.ymdhmsFormatS(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(lasttime);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.HOUR_OF_DAY, now.get(Calendar.HOUR_OF_DAY) + hour);
        Date lastdate = now.getTime();
        return date2Long(lastdate);
    }

    /**
     * @param time 当前时间 加上指定的分钟
     * @param minute 分钟
     * @return 提前到指定分钟的时间
     */
    public final static Long getLastTimeAddMinute(Long time, int minute) {
        String lasttime = DateUtils.ymdhmsFormatS(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(lasttime);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minute);
        Date lastdate = now.getTime();
        return date2Long(lastdate);
    }

    /**
     * @param time 当前时间 long
     * @param mi 跨越天数
     * @return 跨天后的时间
     */
    public final static Long getMisTime(Long time, int mi) {
        String lasttime = DateUtils.ymdhmsFormatS(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(lasttime);
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + mi);
        Date lastdate = now.getTime();
        return date2Long(lastdate);
    }

    /**
     * 将14位数字时间转换为yyyy-MM-dd HH:mm String时间:精确到分钟
     *
     * @author zhouhuajun 2011-03-24 10:59
     * @param l ：14位的时间
     */
    public final static String ymdhmFormatM(Long l) {
        if (l == null || l.toString().length() != 14) {
            log.debug("Long date Error: " + l);
            return "";
        }
        String str = l.toString();
        return str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8) + " "
                + str.substring(8, 10) + ":" + str.substring(10, 12);
    }

    public static String getHms(Date date) {
        if (date == null)
            return "";
        return new SimpleDateFormat("HHmmss").format(date);

    }

    public static boolean varifyDate(String dateStr) {

        if (StringUtils.isBlank(dateStr))
            return false;
        if (dateStr.length() != 10)
            return false;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            df.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;

    }

    public static Date long2Date(long time) {
        DateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMDATE_TO_SECOND);
        Date date = null;
        try {
            date = df.parse(time + "");
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return date;
    }

    public static String getHm(Date date) {
        if (date == null)
            return "";
        return new SimpleDateFormat("yyyyMMddHHmm").format(date);
    }

    /**
     * 用于返回指定日期格式的日期增加指定天数的日期
     *
     * @author zhouhj 2011-08-15 10:21
     * @param appDate 指定日期
     * @param format 指定日期格式
     * @param days 指定天数
     * @return 指定日期格式的日期增加指定天数的日期
     */
    public static Date getFutureDayInDays(String appDate, String format, int days) throws Exception {
        if (StringUtils.isBlank(appDate) || StringUtils.isBlank(format)) {
            if (log.isDebugEnabled()) {
                log.debug("method getFutureDayInDays parms null");
            }
            throw new Exception("parm null");
        }
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            Date date = simpleDateFormat.parse(appDate);
            calendar.setTime(date);
            calendar.add(Calendar.DATE, days);
            date = calendar.getTime();
            return date;
        } catch (Exception e) {
            throw new Exception("method getFutureDayInDays error", e);
        }
    }

    /**
     * 用于返回指定日期格式的日期增加指定天数的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getFutureDayInDays(Date date, int days) {
        Assert.notNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    /**
     * 重载上面的方法，今天的days天数后的时间
     *
     * @author zhouhj 2011-08-15 10:21
     * @param format 指定日期格式
     * @param days 指定天数
     * @return 指定日期格式的日期增加指定天数的日期
     */
    public static Date getFutureDayInDays(String format, int days) throws Exception {
        if (StringUtils.isBlank(format)) {
            if (log.isDebugEnabled()) {
                log.debug("method getFutureDayInDays parms null");
            }
            throw new Exception("param null");
        }
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, days);
            date = calendar.getTime();
            return date;
        } catch (Exception e) {
            throw new Exception("method getFutureDayInDays error", e);
        }
    }

    /**
     * 用于返回指定日期格式的日期增加指定月数的日期
     *
     * @author zhouhj 2011-08-15 10:25
     * @param appDate 指定日期
     * @param format 指定日期格式
     * @param months 指定天数
     * @return 指定日期格式的日期增加指定天数的日期
     */
    public static Date getFutureDayInMonth(String appDate, String format, int months)
            throws Exception {
        if (StringUtils.isBlank(format)) {
            if (log.isDebugEnabled()) {
                log.debug("method getFutureDayInDays param null");
            }
            throw new Exception("param null");
        }
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            Date date = simpleDateFormat.parse(appDate);
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            date = calendar.getTime();
            return date;
        } catch (Exception e) {
            throw new Exception("method getFutureDayInMonth error", e);
        }
    }

    /**
     * 重载上面getFutureDayInMonth的方法，得到今天months月后的时间
     *
     * @author zhouhj 2011-08-15 10:25
     * @param appDate 指定日期
     * @param format 指定日期格式
     * @param months 指定天数
     * @return 指定日期格式的日期增加指定天数的日期
     */
    public static Date getFutureDayInMonth(String format, int months) throws Exception {
        if (StringUtils.isBlank(format)) {
            if (log.isDebugEnabled()) {
                log.debug("method getFutureDayInDays parms null");
            }
            throw new Exception("param null");
        }
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, months);
            return calendar.getTime();
        } catch (Exception e) {
            throw new Exception("method getFutureDayInMonth error", e);
        }
    }

    /**
     * 获取当前时间（字符串）
     *
     * @param format 时间格式
     * @return
     */
    public static String getToday(String format) {
        try {
            SimpleDateFormat df = null;
            if (null == format) {
                df = new SimpleDateFormat("yyyy-MM-dd");
            } else {
                df = new SimpleDateFormat(format);
            }
            return df.format(new Date());
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取当前时间之后（之前）的日期
     *
     * @param days 天数
     * @return 指定日期格式的日期增加指定天数的日期
     */
    public static Date getFutureDayInDays(int days) {
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, days);
            return calendar.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到想减后的年 <li>如果reduceYear传进来是2，如果是在2011年，那么返回去的年应该是2009年<li>
     *
     * @param reduceYear 想减年的个数
     * @return 得到想减后的年份
     */
    public static int getReduceYear(int reduceYear) {
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, -reduceYear);
            return Integer.parseInt(DateUtils.format(calendar.getTime(),
                    DateUtils.DATE_FORMATE_TO_YEAR));
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取想减月数后的年月,例如当前时间2015-09-08 16:15:20,reduceMonth=12,将得到2014-09-08 16:15:20
     *
     * @param reduceMonth
     * @return
     */
    public static String getReduceMonth(int reduceMonth) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -reduceMonth);
        return DateUtils.format(calendar.getTime(), DateUtils.DEFAULT_TIME_FORMATE);
    }

    /**
     * 得到两个日期想减后的天数. <li>公式：传进来的日期-现在的日期</li> <li>日期的格式：yyyyMMddHHmmss</li>
     *
     * @param endDate 传进来的日期
     * @return 两个日期想减后的天数
     */
    public static int getReduceDay(String endDate) {
        if (StringUtils.isBlank(endDate)) {
            return 0;
        }
        try {
            Date date = new Date();
            String formdateDate = DateUtils.format(date, DateUtils.DATE_FORMDATE_TO_SECOND);
            SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMDATE_TO_SECOND);
            // 两天相差的豪秒数
            long dif = df.parse(endDate).getTime() - df.parse(formdateDate).getTime();
            // 最后把豪秒换算成天
            return (int) (dif / (24 * 3600000));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }

    /**
     * 得到两个日期想减后的分钟数
     *
     * @param startDate 相减的时间
     * @param endDate 被相减的时间.
     * @return 两个日期想减后的分
     */
    public static Long getReduceMinute(Long startDate, Long endDate) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMDATE_TO_SECOND);
            // 两天相差的豪秒数
            long dif =
                    df.parse(String.valueOf(startDate)).getTime()
                            - df.parse(String.valueOf(endDate)).getTime();
            // 最后把豪秒换算成分
            return (dif / (1000 * 60));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }

    /**
     * 得到两个日期想减后的分钟数
     *
     * @param startDate 相减的时间
     * @param endDate 被相减的时间.
     * @return 两个日期想减后的分
     */
    public static Long getReduceHour(Long startDate, Long endDate) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateUtils.DATE_FORMDATE_TO_SECOND);
            // 两天相差的豪秒数
            long dif =
                    df.parse(String.valueOf(startDate)).getTime()
                            - df.parse(String.valueOf(endDate)).getTime();
            // 最后把豪秒换算成分
            return (dif / (1000 * 3600));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }

    /**
     * 得到两个日期想减后的天数
     *
     * @param reduceDate 想减的时间
     * @param byReduceDate 被想减的时间.
     * @return 两个日期想减后的天数
     */
    public static Long getReduceDay(String reduceDate, String byReduceDate) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(DateUtils.DEFAULT_TIME_FORMATE);
            // 两天相差的豪秒数
            long dif = df.parse(reduceDate).getTime() - df.parse(byReduceDate).getTime();
            // 最后把豪秒换算成天
            return (dif / (1000 * 3600));
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return 0L;
        }
    }

    /**
     * 获得当前星期
     *
     * @return
     */
    public static String getWeek() {
        Calendar c = Calendar.getInstance();
        String[] weeks = new String[] {"日", "一", "二", "三", "四", "五", "六"};
        int weekNum = c.get(Calendar.DAY_OF_WEEK) - 1;
        return weeks[weekNum];
    }

    /**
     * 计算两个时间相减得到的天数 传如参数必须为(yyyy-MM-dd HH:mm:ss)格式。
     *
     * @param args
     */
    public static String getDays(String starDate, String endDate) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sdf.parse(starDate);
            Date date2 = sdf.parse(endDate);
            long day =
                    (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) > 0 ? (date1
                            .getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) : (date2
                            .getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);
            return String.valueOf(day);

        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return "";

        }

    }

    /**
     * @param timeLong Sets this <code>Date</code> object to represent a point in time that is
     *        <code>time</code> milliseconds after January 1, 1970 00:00:00 GMT.
     * @return yyyy-MM-dd HH:mm:ss 格式的时间
     */
    public static String getDateLong2String(Long timeLong) {

        Date date = new Date();
        date.setTime(timeLong);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 判断当前时间减去参数时间，获取到分值
     *
     * @param endDate
     * @return
     */
    public static long getMintues(Date endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date currentDate = sdf.parse(getToday("yyyy-MM-dd HH:mm:ss"));
            long minutes = (currentDate.getTime() - endDate.getTime()) / (60 * 1000);
            return minutes;
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            return 1l;
        }
    }

    /**
     * 判断日期是否在指定的时间段内
     *
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return true 在有效的时间段内 false不在有效的时间段内
     */
    public static boolean isDateEffecRange(Date startDate, Date endDate) {
        Date newDate = new Date();
        boolean isEffect = false;
        if (newDate.after(startDate) && newDate.before(endDate)) {
            isEffect = true;
        }
        return isEffect;
    }

    public static void main(String[] args) throws ParseException {
        // Long ss = 20110529235554L;
        // Long ee = 20110529125554L;
        // Long now = DateUtils.date2Long(new Date());
        // System.out.println(DateUtils.getBefore48Month());
        System.out.println(DateUtils.format(new Date(), DateUtils.DEFAULT_DATE_FORMATE));
        System.out.println(DateUtils.formatDateTime(DateUtils.addMonth(new Date(), 3)));
        // System.out.println(DateUtils.getCurrentQuarterStartTime("2017-09-21"));
        System.out.println(DateUtils.formatDateTime(addMinute(new Date(), 30)));
    }

    /**
     * 获取年月yyyy-MM的时间字符串
     *
     * @param date
     * @return
     */
    public final static String getFormatToMonth(Date date) {
        return format(date, DATE_FORMATE_TO_MONTH);
    }

    public final static Date addYear(Date pDate, int year) {
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + year);
        return c.getTime();
    }

    public final static Date addMonth(Date pDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + month);
        return c.getTime();
    }

    public final static Date addMinute(Date pDate, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minute);
        return c.getTime();
    }

    public final static Date addHour(Date pDate, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + hour);
        return c.getTime();
    }

    public final static Date addDay(Date pDate, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(pDate);
        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + day);
        return c.getTime();
    }

    public final static String getBit(int a, int bit) {
        String b = "0000000000000" + a;
        return b.substring(b.length() - bit);
    }

    /**
     * 比较两个日期大小：comparedDate大于baseDate返回1;comparedDate小于baseDate返回-1 comparedDate等于baseDate返回0
     *
     * @param comparedDate ：日期字符"2015-10-01"
     * @param baseDate ：日期字符"2015-10-01"
     * @return
     */
    public final static int compareDate(String comparedDate, String baseDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Integer flag = 0;
        try {
            Date compared = df.parse(comparedDate);
            Date base = df.parse(baseDate);
            if (compared.getTime() > base.getTime()) {
                flag = 1;
            } else if (compared.getTime() < base.getTime()) {
                flag = -1;
            }
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 比较两个时间大小：comparedDate大于baseDate返回1;comparedDate小于baseDate返回-1 comparedDate等于baseDate返回0
     *
     * @param comparedDate ：日期字符"2015-10-01 09:05:30"
     * @param baseDate ：日期字符"2015-10-01 09:05:30 "
     * @return
     */
    public final static int compareTime(String comparedDate, String baseDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer flag = 0;
        try {
            Date compared = df.parse(comparedDate);
            Date base = df.parse(baseDate);
            if (compared.getTime() > base.getTime()) {
                flag = 1;
            } else if (compared.getTime() < base.getTime()) {
                flag = -1;
            }
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 得到想减年数后的日期,reduceYear=5得到“2010-10-23”
     *
     * @param reduceYear
     * @return
     */
    public final static String getReduceYearDate(int reduceYear) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -reduceYear);
        return df.format(c.getTime());
    }

    /**
     * 获得特定时间与当前时间的天数差值，如果特定时间小于当前时间，返回0
     *
     * @throws Exception
     */
    public final static int getDifferenceDate(String ddate) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long nowTime = df.parse(df.format(new Date())).getTime();// 当前的时间
        long endTime = df.parse(ddate).getTime();// 结束时间
        long diff = nowTime - endTime;
        long dd = (long) 1000 * 24 * 60 * 60;// 一天的毫秒数
        if (diff > 0) {
            return 0;
        } else {
            int d = (int) (-diff / dd) + 1;
            return d;
        }

    }

    /**
     * 获取两个日期之间的天数
     *
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public final static int getDifferDays(String startDate, String endDate) throws Exception {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            long startTime = df.parse(startDate).getTime();// 当前的时间
            long endTime = df.parse(endDate).getTime();// 结束时间
            long diff = endTime - startTime;
            long dd = (long) 1000 * 24 * 60 * 60;// 一天的毫秒数
            if (diff < 0) {
                return 0;
            } else {
                int d = (int) (diff / dd) + 1;
                return d;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取指定日期跟当前日期的天数差
     *
     * @param ddate
     * @return
     * @throws ParseException
     */
    public final static int getDiffeDays(String ddate) throws ParseException {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            long nowTime = df.parse(df.format(new Date())).getTime();// 当前的时间
            long endTime = df.parse(ddate).getTime();// 结束时间
            long diff = endTime - nowTime;
            long dd = (long) 1000 * 24 * 60 * 60;// 一天的毫秒数
            if (diff < 0) {
                diff = 0 - diff;
            }
            int d = (int) (diff / dd);
            return d;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获取当月的第一天
     *
     * @return
     */
    public final static String getMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(cal.getTime());
    }

    /**
     * 获取（加上/减去）year后年份的第一天日期
     *
     * @param year
     * @return
     */
    public final static String getReduceYearFirstDay(int year) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(cal.getTime());
    }

    /**
     * 获取指定月份的天数
     *
     * @param date
     * @param amount 偏差月份数 上一个月就是-1
     * @return
     * @throws ParseException
     */
    public final static int getMaxDayOfMonth(String date, int amount) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(date));
        if (amount != 0) {
            c.set(Calendar.DAY_OF_MONTH, 1);
            c.add(Calendar.MONTH, amount);
        }
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 根据起始时间，返回中间经历的月份列表
     *
     * @param startDate
     * @param endDate
     * @param format 返回month的格式
     * @param h 是否需要最后一个月 0需要，1不需要
     * @return
     * @throws Exception
     */
    public final static List<String> getMonthList(String startDate, String endDate, String format,
                                                  int h) throws Exception {
        List<String> li = new ArrayList<String>();
        Calendar start = Calendar.getInstance();
        start.setTime(DateUtils.parse(startDate, "yyyy-MM-dd"));
        String endMonth = format(parse(endDate, "yyyy-MM-dd"), format);
        String month = "";
        while (true) {
            month = format(start.getTime(), format);
            if (month.equals(endMonth)) {
                if (h == 0) {
                    li.add(month);
                }
                break;
            } else {
                li.add(month);
            }
            start.add(Calendar.MONTH, 1);
        }
        return li;
    }

    /**
     * 根据起始时间，返回中间经历的天列表
     *
     * @param startDate
     * @param endDate
     * @param format 返回天的格式
     * @param h 是否需要最后一个天 0需要，1不需要
     * @return
     * @throws Exception
     */
    public final static List<String> getDayList(String startDate, String endDate, String format,
                                                int h) throws Exception {
        try {
            if (startDate.compareTo(endDate) > 0) {
                return new ArrayList<String>();
            }
            List<String> li = new ArrayList<String>();
            Calendar start = Calendar.getInstance();
            start.setTime(DateUtils.parse(startDate, "yyyy-MM-dd"));
            String endDay = format(parse(endDate, "yyyy-MM-dd"), format);
            String day = "";
            while (true) {
                day = format(start.getTime(), format);
                if (day.equals(endDay)) {
                    if (h == 0) {
                        li.add(day);
                    }
                    break;
                } else {
                    li.add(day);
                }
                start.add(Calendar.DAY_OF_MONTH, 1);
            }
            return li;
        } catch (Exception e) {
            return new ArrayList<String>();
        }
    }

    /*
     * 取本周7天的第一天（周一的日期）
     */
    public static String getNowWeekBegin() {
        int mondayPlus;
        Calendar cd = Calendar.getInstance();
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
        if (dayOfWeek == 1) {
            mondayPlus = 0;
        } else {
            mondayPlus = 1 - dayOfWeek;
        }
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = currentDate.getTime();

        String preMonday = formatDate(monday);

        return preMonday + " 00:00:00";

    }

    /***
     * 判断一个日期是否为该月最后一天
     *
     * @param date
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        String day = DateUtils.format(date, "dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDayOfMonth = calendar.getTime();
        String lastDay = DateUtils.format(lastDayOfMonth, "dd");
        if (day.equals(lastDay)) {
            return true;
        }
        return false;
    }

    /***
     * 根据年份，月份，获取该月最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(String year, String month) {
        Date date = parse(year + "-" + month + "-01", "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDayOfMonth = calendar.getTime();
        return DateUtils.format(lastDayOfMonth, "dd");
    }

    /**
     * 获取当前月第一天
     *
     * @return
     */
    public static String getCurrentMonth() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前1月第一天
     *
     * @return
     */
    public static String getBefore1Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -1);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前2月第一天
     *
     * @return
     */
    public static String getBefore2Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -2);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前3月第一天
     *
     * @return
     */
    public static String getBefore3Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -3);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前6月第一天
     *
     * @return
     */
    public static String getBefore6Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -6);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前9月第一天
     *
     * @return
     */
    public static String getBefore9Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -9);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前12月第一天
     *
     * @return
     */
    public static String getBefore12Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -1);
        cale.add(Calendar.DATE, 1);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前13月第一天
     *
     * @return
     */
    public static String getBefore13Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -1);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -1);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前15月第一天
     *
     * @return
     */
    public static String getBefore15Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -1);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -3);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前18月第一天
     *
     * @return
     */
    public static String getBefore18Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -2);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, 6);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前24月第一天
     *
     * @return
     */
    public static String getBefore24Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -2);
        cale.add(Calendar.DATE, 1);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前36月第一天
     *
     * @return
     */
    public static String getBefore36Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -3);
        cale.add(Calendar.DATE, 1);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前40月第一天
     *
     * @return
     */
    public static String getBefore40Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -3);
        cale.add(Calendar.DATE, 1);
        cale.add(Calendar.MONTH, -4);
        return formatDate(cale.getTime());
    }

    /**
     * 获取前48月第一天
     *
     * @return
     */
    public static String getBefore48Month() {
        Calendar cale = Calendar.getInstance();
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.add(Calendar.YEAR, -4);
        cale.add(Calendar.DATE, 1);
        return formatDate(cale.getTime());
    }

    public static String getYoYMonth(String yearMonth) {
        String year = yearMonth.split("-")[0];
        String month = yearMonth.split("-")[1];
        String monthYoY = (Integer.valueOf(year) - 1) + "-" + month;
        return monthYoY;
    }

    public static String getChainMonth(String yearMonth) {
        String year = yearMonth.split("-")[0];
        String month = yearMonth.split("-")[1];
        String monthChain = "";
        if (Integer.valueOf(month) - 1 == 0) {
            monthChain = (Integer.valueOf(year) - 1) + "-12";
        } else {
            monthChain =
                    year
                            + "-"
                            + ((Integer.valueOf(month) - 1) < 10 ? "0"
                            + (Integer.valueOf(month) - 1) : Integer.valueOf(month) - 1);
        }
        return monthChain;
    }

    /**
     * 计算两个日期相差的月份数
     *
     * @param start <String>
     * @param end <String>
     * @return int
     * @throws ParseException
     */
    public static int monthsBetween(String start, String end) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();

        startDate.setTime(sdf.parse(start));
        endDate.setTime(sdf.parse(end));
        int result =
                (endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR)) * 12
                        + endDate.get(Calendar.MONTH) - startDate.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 当前季度的开始时间
     *
     * @return
     */
    public static String getCurrentQuarterStartTime(String dateStr) throws ParseException {
        String now = "";
        int currentMonth = 0;
        Calendar c = null;
        if (StringUtils.isBlank(dateStr)) {
            c = Calendar.getInstance();
            currentMonth = c.get(Calendar.MONTH) + 1;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);
            c = Calendar.getInstance();
            c.setTime(date);
            currentMonth = c.get(Calendar.MONTH) + 1;
        }
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 6);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = format(c.getTime(), DEFAULT_DATE_FORMATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获取给定时间段里的季度（例如2014-1，2014-2，2014-3，2014-4）
     *
     * @param sTime
     * @param eTime
     * @return
     */
    public static List getQuarterTail(DateTime sTime, DateTime eTime) {
        // 月数总跨度(示例中一共24个月)
        int mounthNum = new Period(sTime, eTime, PeriodType.months()).getMonths() + 1;
        List<String> quarterList = new ArrayList<String>();
        // 开始月份(示例中为1)
        int sMonth = sTime.getMonthOfYear();
        // 开始时间到第一个季尾剩余月数(示例中为1，即到3月还剩2个月)
        int leftMonth =
                (MONTHS_OF_QUARTER == MONTHS_OF_QUARTER - (sMonth % MONTHS_OF_QUARTER) ? 0
                        : MONTHS_OF_QUARTER - (sMonth % MONTHS_OF_QUARTER));
        // 得到第一个季尾月(示例中开始为1月，即第一个季尾为3月)
        DateTime quarterTail = sTime.plusMonths(leftMonth);
        for (int i = 0; i < mounthNum; i = i + MONTHS_OF_QUARTER) {
            quarterList.add(new DateTime(quarterTail).toString(TIME_FORMATE_MONTH));
            quarterTail = quarterTail.plusMonths(MONTHS_OF_QUARTER);
        }

        List<String> retList = new ArrayList();
        // 遍历，看下结果喽，list长度就是季度数
        for (String a : quarterList) {
            String b = "";
            if ("03".equals(a.substring(5))) {
                b = a.substring(0, 4) + "-1";
            } else if ("06".equals(a.substring(5))) {
                b = a.substring(0, 4) + "-2";
            } else if ("09".equals(a.substring(5))) {
                b = a.substring(0, 4) + "-3";
            } else {
                b = a.substring(0, 4) + "-4";
            }
            retList.add(b);
        }
        return retList;
    }

    /**
     * 当前季度的开始时间
     *
     * @return
     */
    public static String getCurrentQuarterStartTime() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String now = "";
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 4);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DATE, 1);
            now = format(c.getTime(), DEFAULT_DATE_FORMATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public static String LongTimeToYMD(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(time))));
        return sd;
    }

    /**
     * 获取指定时间前24月第一天
     *
     * @return
     */
    public static String getBefore24Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }

            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.YEAR, -2);
            cale.add(Calendar.DATE, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return formatDate(cale.getTime());
    }



    /**
     * 获取指定时间所在月第一天
     *
     * @return
     */
    public static String getCurrentMonth(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }

            cale.set(Calendar.DAY_OF_MONTH, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }



    /**
     * 获取指定日期前12月第一天
     *
     * @return
     */
    public static String getBefore12Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }

            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.YEAR, -1);
            cale.add(Calendar.DATE, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }



    /**
     * 获取指定时间前36月第一天
     *
     * @return
     */
    public static String getBefore36Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }

            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.YEAR, -3);
            cale.add(Calendar.DATE, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }



    /**
     * 获取指定日期前48月第一天
     *
     * @return
     */
    public static String getBefore48Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }

            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.YEAR, -4);
            cale.add(Calendar.DATE, 1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }


    /**
     * 获取指定日期前3月第一天
     *
     * @return
     */
    public static String getBefore3Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }
            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.DATE, 1);
            cale.add(Calendar.MONTH, -3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }



    /**
     * 获取指定日期前6月第一天
     *
     * @return
     */
    public static String getBefore6Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }
            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.DATE, 1);
            cale.add(Calendar.MONTH, -6);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }


    /**
     * 获取前几年第一天
     *
     * @return
     */
    public static String getBeforeNumYear(String dateTime, int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }
            cale.set(Calendar.DAY_OF_YEAR, 0);
            cale.add(Calendar.DATE, 1);
            // cale.add(Calendar.MONTH_OF_YEAR, 0);
            num = Math.abs(num);
            cale.add(Calendar.YEAR, -num);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }


    public static String getTomorrowDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return format(c.getTime(), DEFAULT_DATE_FORMATE);
    }

    public static int getTodayRemainderMinuts() {
        Calendar cal = Calendar.getInstance();
        long now = cal.getTime().getTime();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long tomorrowStart = cal.getTime().getTime();
        int remainderMinutes = (int) ((tomorrowStart - now) / (60 * 1000));
        return remainderMinutes;
    }

    /**
     * 获取指定日期前1月第一天
     *
     * @return
     */
    public static String getBefore1Month(String dateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cale = Calendar.getInstance();
        try {
            if (StringUtils.isNotBlank(dateTime)) {
                cale.setTime(sdf.parse(dateTime));
            }
            cale.set(Calendar.DAY_OF_MONTH, 0);
            cale.add(Calendar.DATE, 1);
            cale.add(Calendar.MONTH, -1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(cale.getTime());
    }

    /**
     * 获取昨天（yyyy-MM-dd）
     *
     * @return
     */
    public static String getYesterdayDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        return format(c.getTime(), DEFAULT_DATE_FORMATE);
    }


    /**
     * 获取一天中凌晨时间
     * @param date
     * @return
     */
    public final static Date getDayBeginTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();
        return start;
    }

    /**
     * 获取一天中指定的小时
     * @param date
     * @return
     */
    public final static Date getDayTimeByHour(Date date,int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date start = calendar.getTime();
        return start;
    }

    /**
     * 获取一天中最晚的时间
     * @param date
     * @return
     */
    public final static Date getDayEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date start = calendar.getTime();
        return start;
    }


}

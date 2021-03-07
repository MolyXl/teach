package cn.teach.common.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    public final static String DEFAULT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public final static String DEFAULT_DATETIME_NO = "yyyyMMddHHmmss";
    public final static String DEFAULT_DATETIME_MILLNO = "yyyyMMddHHmmssSSS";
    public final static String DEFAULT_DATE = "yyyy-MM-dd";
    public final static String DEFAULT_CODE_DATE = "yyyyMMdd";

    /**
     * @Author MaZhuli
     * @Description 获取当前时间
     * @Date 2019/3/8 10:51
     * @Param []
     * @Return java.lang.String
     **/
    public static String currentDateTime() {
        return ToDateString(new Date(), DEFAULT_DATETIME);
    }

    /**
     * @Author MaZhuli
     * @Description 获取当前时间
     * @Date 2019/3/8 10:51
     * @Param []
     * @Return java.lang.String
     **/
    public static String currentDateTimeNo() {
        return ToDateString(new Date(), DEFAULT_DATETIME_NO);
    }

    /**
     * @Author: MaZhuli
     * @Date: 2019/8/23
     * @Description: 带毫秒的编号
     */
    public static String currentTimeMILLNo() {
        return ToDateString(new Date(), DEFAULT_DATETIME_MILLNO);
    }

    /**
     * @Author MaZhuli
     * @Description 获取当前日期
     * @Date 2019/3/8 10:51
     * @Param []
     * @Return java.lang.String
     **/
    public static String currentDate() {
        return ToDateString(new Date(), DEFAULT_DATE);
    }

    /**
     * @Author MaZhuli
     * @Description 获取年月日以生产编码
     * @Date 2019/3/11 16:49
     * @Param []
     * @Return java.lang.String
     **/
    public static String codeDate() {
        return ToDateString(new Date(), DEFAULT_CODE_DATE);
    }

    /**
     * @Author MaZhuli
     * @Description 按某种格式将日期转换为String
     * @Date 2019/3/8 10:52
     * @Param [date, format]
     * @Return java.lang.String
     **/
    public static String ToDateString(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_DATETIME;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * @Author MaZhuli
     * @Description 将字符串转为日期类型
     * @Date 2019/3/25 11:22
     * @Param [dateTime]
     * @Return java.util.Date
     **/
    public static Date stringToDate(String dateTime) throws ParseException {
        if (StringUtils.isEmpty(dateTime)) {
            return new Date();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE);
        Date parse = dateFormat.parse(dateTime);
        return parse;
    }

    /**
     * @Author MaZhuli
     * @Description 获取当前时间戳
     * @Date 2019/3/8 18:43
     * @Param []
     * @Return java.lang.String
     **/
    public static String currentTime() {
        return ((Long) (new Date()).getTime()).toString();
    }

    public static long getMillis(long time, TimeUnit unit) throws Exception {
        if (unit.equals(TimeUnit.SECONDS)) {
            return time * 1000;
        } else if (unit.equals(TimeUnit.MINUTES)) {
            return time * 60000;
        } else if (unit.equals(TimeUnit.HOURS)) {
            return time * 60 * 60000;
        } else if (unit.equals(TimeUnit.DAYS)) {
            return time * 24 * 60 * 60000;
        }
        throw new Exception("参数无效");
    }

    public static Date getToday() throws ParseException {
        return DateUtil.stringToDate(DateUtil.currentDate());
    }

    public static Date getTommorrow(Date today) throws ParseException {
        if (today != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.DAY_OF_YEAR, 1);
            return c.getTime();
        } else {
            return null;
        }
    }
    public static Date getTheDayPast(Date today,Integer days) throws ParseException {
        if (today != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(today);
            c.add(Calendar.DAY_OF_YEAR, days);
            return c.getTime();
        } else {
            return null;
        }
    }

}

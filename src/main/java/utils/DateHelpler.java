package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelpler {

    private static String datePattern = "yyyy-MM-dd";
    private static String timePattern = "yyyy-MM-dd HH:mm";
    private static String dateMoth = "yyyy-MM";
    private static String timePattern2 = "yyyy-MM-dd HH:mm:ss";
    private static String timeForAlarm = "yyyy.MM.dd HH:mm:ss";
    private static String timePattern3 = "yyyy年MM月dd日HH时";

    public static String getDateMatchOne() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timePattern2);
        String timeStampStr = simpleDateFormat.format(date);
        return timeStampStr;
    }

    public static String getDateMatchTwo() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String timeStampStr = simpleDateFormat.format(date);
        return timeStampStr;
    }

    public static String getTokenExpirationDate(Date exp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timePattern2);
        return simpleDateFormat.format(exp);
    }

}

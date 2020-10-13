package com.mxw.inandoutschool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final String timeTag = "yyyy-MM-dd";
    public static final String endTime = "M.d结束";
    public static final String preTime = "H:mm开播";
    public static final String detail_pretime = "M月d日 H:mm开播";
    public static final String search_content = "M月d日";
    public static String getTime(long time, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date(Long.parseLong(String.valueOf(time)) * 1000L));
    }
    public static String isRecentDay(long data, String timeStyle){
        String time = null;
        long timeStamp = System.currentTimeMillis()/1000;
        String today = TimeUtil.getTime(timeStamp,timeStyle);
        String tomorrow = TimeUtil.getTime(timeStamp + 86400,timeStyle);
        String houtian = TimeUtil.getTime(timeStamp + 2 * 86400,timeStyle);
        if (today.equals(TimeUtil.getTime(data,timeStyle))){
            time = "今天";
        }else if (tomorrow.equals(TimeUtil.getTime(data,timeStyle))){
            time = "明天";
        }else if (houtian.equals(TimeUtil.getTime(data,timeStyle))){
            time = "后天";
        }
        else{
            time = TimeUtil.getTime(data,timeStyle);
        }
        return time;
    }
    public static String isRecentDayForAuthor(long data, String timeStyle){
        String time = null;
        long timeStamp = System.currentTimeMillis()/1000;
        String today = TimeUtil.getTime(timeStamp,timeTag);
        String tomorrow = TimeUtil.getTime(timeStamp + 86400,timeTag);
        String houtian = TimeUtil.getTime(timeStamp + 2 * 86400,timeTag);
        if (today.equals(TimeUtil.getTime(data,timeTag))){
            time = "今天" + getTime(data,preTime);
        }else if (tomorrow.equals(TimeUtil.getTime(data,timeTag))){
            time = "明天" + getTime(data,preTime);
        }else if (houtian.equals(TimeUtil.getTime(data,timeTag))){
            time = "后天" + getTime(data,preTime);
        }
        else{
            time = TimeUtil.getTime(data,timeStyle);
        }
        return time;
    }
}

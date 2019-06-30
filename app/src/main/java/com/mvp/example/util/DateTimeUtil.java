package com.mvp.example.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateTimeUtil {

    public static String convertDate(String locaTime) {
        String replacedLocalTime = locaTime.replace("T", " ");
        DateFormat originalFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date origianlDate = null;
        try {
            origianlDate = originalFormatter.parse(replacedLocalTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat newFormatter = new SimpleDateFormat("EEE MMM dd YYYY HH:mm");
        String newDate = newFormatter.format(origianlDate);

        return newDate;
    }

}

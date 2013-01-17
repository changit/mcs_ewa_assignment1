package org.team5.ws.adapters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chandana
 * Date: 1/10/13
 * Time: 11:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateAdapter {

    private static final ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZ");
        }
    };

    public static String unmarshal(Date date) {
        return  dateFormatter.get().format(date);
    }


    public static Date marshal(String dateString) {
        try {
            return dateFormatter.get().parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date in [ " + dateString + " ] ");
        }
    }
}

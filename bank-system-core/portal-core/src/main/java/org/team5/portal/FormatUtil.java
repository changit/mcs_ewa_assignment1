package org.team5.portal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chan
 * Date: 12/29/12
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class FormatUtil {

    private static final ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("yyyy/MM/dd");
        }
    };

    public static String formatDate(Date date){
       return dateFormatter.get().format(date);
    }
}

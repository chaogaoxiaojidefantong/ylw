	package com.canteen.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

    public class TimeUtil {

            /**
             * 返回当前时间的string型
             * @return
             */
            public static String nowtime() {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date=df.format(new Date());
                return date;
            }

            /**
             *返回当天的日期，比如2018/11/11
             * @return
             */
            public static String nowday() {
                return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            }
            /**
             * 返回时钟,比如11:20:15
             * @return
             */
            public static String nowtime1() {
                SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
                return df.format(new Date());
            }



        }

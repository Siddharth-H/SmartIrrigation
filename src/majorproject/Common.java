/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject;

import Connection.conn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Purvi
 */
public class Common {

    public static String USER_NAME = "";
    public static int USER_ID;
    public static String USER_EMAIL = "";
    public static String USER_PHONE = "";
    public static String USER_ADDRESS = "";
    public static int PLANT_ID;
    public static int FARM_ID;
    public static LocalDateTime CURRENT_TIME;

    public static Date TODAY = new Date();

    public static long WATER_USAGE_NUM = 15;
    public static Long WATER_USAGE_TODAY = new Long(WATER_USAGE_NUM);

    public static long MOTOR_ACTIVE_NUM = 3;
    public static Long MOTOR_ACTIVE_TIME = new Long(MOTOR_ACTIVE_NUM);

    public static long AVG_WATER_USAGE_NUM = 6;
    public static Long AVG_WATER_USAGE_TODAY = new Long(AVG_WATER_USAGE_NUM);

    public static String ADMIN_EMAIL = "purvi.pahadiya.7@gmail.com";

    //Siddarth 
    public static int waterRate = 20; //litres per min
    public static int valve_start_time_hr;
    public static int valve_start_time_min;
    public static int valve_stop_time_hr;
    public static int valve_stop_time_min;
    public static int active_time_min;
    public static String valve_state = "OFF";

    public static boolean checkUser() {
        Connection con = conn.getCon();

        String sql = "Select * from users";
        boolean st = false;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            st = res.next();

        } catch (Exception e) {
        }
        return st;
    }

    public static void getUser() {
        Connection con = conn.getCon();

        String sql = "Select * from users";
        boolean st = false;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Common.USER_ID = res.getInt(1);
                Common.USER_NAME = res.getString(2);
                Common.USER_EMAIL = res.getString(3);
            }

        } catch (Exception e) {
        }
    }

    public static boolean checkFarm() {
        Connection con = conn.getCon();

        String sql = "Select * from farm";
        boolean st = false;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            st = res.next();

        } catch (Exception e) {
        }
        return st;
    }

    public static void openIndexPage() {
        Index.mainIndex();
//        Index indexObj = new Index();
//        indexObj.setSerialPort();
//        indexObj.setMinMoisture();
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//
//                indexObj.startInfiniteLoop();
//
//            }
//        };
//        t.start();
    }

}

package com.project.util;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NTPTime {

    private static final String NIST_TIME_URI = "132.163.97.1";

    public static String getNTPTime() {
        try {
            NTPUDPClient ntpudpClient = new NTPUDPClient();
            InetAddress timeServerAddress = InetAddress.getByName(NIST_TIME_URI);
            TimeInfo timeInfo = ntpudpClient.getTime(timeServerAddress);
            TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
            Date date = timeStamp.getDate();
//            System.out.println(date);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Unavailable to get time";
    }
}

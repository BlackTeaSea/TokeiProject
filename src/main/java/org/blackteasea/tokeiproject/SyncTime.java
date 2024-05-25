package org.blackteasea.tokeiproject;

import java.time.*;

public class SyncTime {

    public static long convertTime(LocalTime time){
        return time.getHour()*1000 + time.getMinute()*(1000/60) + (long)((float)time.getSecond()*(float)(10/36));
    }
    public static long convertFloatTime(float time){
        return (long)(time * 1000);
    }

    public static float getTimeRatio(float minecraftSeconds){
        return 1/minecraftSeconds;
    }

    public static long getDiffTime(long iTime, long fTime){
        if(iTime > fTime){
            return (24000 - iTime - fTime);
        }
        return fTime - iTime;
    }

}

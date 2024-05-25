package org.blackteasea.tokeiproject;

import java.time.*;

public class SyncTime {

    public static long convertTime(LocalTime time){
        return time.getHour()*1000 + time.getMinute()*(1000/60);
    }
    public static long convertFloatTime(float time){
        return (long)(time * 1000);
    }

    public static float getTimeRatio(float minecraftSeconds){
        return 1/minecraftSeconds;
    }


    public static float getFloatTime(LocalTime time){
        return time.getHour() + (float)time.getMinute()/60 + (float)time.getSecond()/3600;
    }

    public static float getDiffTime(LocalTime iTime, LocalTime fTime){
        float initTime = getFloatTime(iTime);
        float finalTime = getFloatTime(fTime);
        if(initTime > finalTime){
            return (24 - initTime - finalTime);
        }
        return finalTime - initTime;
    }

}

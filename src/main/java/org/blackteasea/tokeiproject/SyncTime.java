package org.blackteasea.tokeiproject;

import org.bukkit.Server;
import org.bukkit.World;

import java.time.*;

public class SyncTime {
    LocalTime time;

    Server server = Data.getInstance().getJavaPlugin().getServer();

    public static long convertTime(LocalTime time){
        long convertedTime = time.getHour()*1000;
        convertedTime += time.getMinute()*(1000/60);

        return convertedTime;
    }
    public static long convertFloatTime(float time){
        return (long)(time * 1000);
    }

    public static float getTimeRatio(float minecraftSeconds){
        return 1/minecraftSeconds;
    }

    public static float getDayAmount(float timeRatio){
        return 24 * timeRatio;
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

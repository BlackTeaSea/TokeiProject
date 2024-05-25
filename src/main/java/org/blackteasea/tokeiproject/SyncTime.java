package org.blackteasea.tokeiproject;

import jdk.vm.ci.meta.Local;
import org.bukkit.Server;
import org.bukkit.World;

import java.time.*;

public class SyncTime {

    Server server = Data.getInstance().getJavaPlugin().getServer();
    static LocalTime time;


    //Synchronizes time on server start
    public static long minecraftAdjust(LocalTime time){
        float calculatedHour = (float)time.getHour();
        float calculatedMinute = ((float)time.getMinute()/60);
        float calculatedSecond = ((float)time.getSecond()/3600);
        float fullCalculatedTime = calculatedHour + calculatedMinute + calculatedSecond;

        return (long)(fullCalculatedTime*1000);
    }
    public static long biDayAdjust(LocalTime time){
        long minecraftTime = minecraftAdjust(time);

        return minecraftTime/36;
    }

    //Synchronizes time on server start. Should not be used on schedule, as this does not advance day.
    public static void absoluteSync(){
        time = LocalTime.now();
        long adjustedTime = biDayAdjust(time);

        for(World world : Data.getInstance().getWorldList()){
            world.setFullTime(adjustedTime);
        }

    }
    //Synchronizes time on schedule. Different from absoluteSync, since this changes the day as well
    public void sync(){
        time = LocalTime.now();
        long adjustedTime = biDayAdjust(time);
        for (World world : Data.getInstance().getWorldList()){
            world.setTime(adjustedTime);
        }
    }
}

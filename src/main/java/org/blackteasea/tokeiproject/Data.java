package org.blackteasea.tokeiproject;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.List;

public class Data extends PropertyChangeSupport {
    //Singleton Setup
    private static Data instance;

    private JavaPlugin plugin;
    private List<World> worldList;
    private LocalTime time;
    private float minecraftSecond;


    //Singleton Setup
    private Data() {
        super(new Object());

    }
    public static Data getInstance(){
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    //PluginManager Setup
    public JavaPlugin getJavaPlugin() {
        return plugin;
    }
    public void setJavaPlugin(JavaPlugin plugin){
        this.plugin = plugin;
    }

    //World
    public List<World> getWorldList(){
        return worldList;
    }
    public void setWorldList(List<World> worldList){
        this.worldList = worldList;
    }

    public LocalTime getTime(){
        return time;
    }
    public void setTime(LocalTime time){
        this.time = time;
    }

    public void setMinecraftSecond(float minecraftSecond) {
        this.minecraftSecond = minecraftSecond;
    }
    public float getMinecraftSecond() {
        return minecraftSecond;
    }

    public void syncWorldTime(){
        long time = SyncTime.convertTime(this.time);
        for(World world : this.worldList){
            world.setTime(time);
        }
    }

    public void adjustWorldTime(LocalTime time){
        LocalTime itime = this.time;
        setTime(time);
        LocalTime ftime = this.time;

        long Diff = SyncTime.convertFloatTime(SyncTime.getDiffTime(itime, ftime));
        long adjDiff = (long)((float)Diff/SyncTime.getTimeRatio(minecraftSecond));

        for(World world : this.worldList){
            world.setTime(world.getTime() + adjDiff);
        }

    }



}

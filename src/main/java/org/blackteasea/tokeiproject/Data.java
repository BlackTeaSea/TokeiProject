package org.blackteasea.tokeiproject;

import jdk.vm.ci.meta.Local;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

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

    public void setMinecraftSecond(float minecraftSecond) {
        this.minecraftSecond = minecraftSecond;
    }
    public float getMinecraftSecond() {
        return minecraftSecond;
    }

    public void syncWorldTime(){
        this.time = LocalTime.now();
        long time = SyncTime.convertTime(this.time);
        this.worldList.forEach(world -> world.setTime((time + 6000)*2));
    }

    public void advanceWorldTime(){
        this.worldList.forEach(world -> world.setTime(world.getTime() + 1L));
    }

    BukkitRunnable advTime = new BukkitRunnable() {
        @Override
        public void run() {
            advanceWorldTime();
        }
    };
}

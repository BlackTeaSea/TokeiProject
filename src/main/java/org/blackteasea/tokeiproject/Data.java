package org.blackteasea.tokeiproject;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
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
        return this.time;
    }
    public void setTime(LocalTime time){
        this.time = time;
    }

    public void syncWorldTime(){
        long time = SyncTime.convertTime(this.time);
        for(World world : this.worldList){
            world.setTime(time);
        }
    }



}

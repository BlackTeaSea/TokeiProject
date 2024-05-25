package org.blackteasea.tokeiproject;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.beans.PropertyChangeSupport;

public class Data extends PropertyChangeSupport {
    //Singleton Setup
    private static Data instance;

    private JavaPlugin plugin;

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




}

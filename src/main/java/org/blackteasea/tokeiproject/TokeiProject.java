package org.blackteasea.tokeiproject;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


import java.time.LocalTime;

import static org.bukkit.GameRule.DO_DAYLIGHT_CYCLE;

public final class TokeiProject extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        LocalTime time = LocalTime.now();
        Data.getInstance().setJavaPlugin(this);

        getLogger().info("Starting the Tokei Plugin");

        //Obtain worldlist to manipulate
        Data.getInstance().setWorldList(getServer().getWorlds());

        //GAMERULES
        //Stops the daylight cycle for all worlds
        getServer().getWorlds().forEach(world -> world.setGameRule(DO_DAYLIGHT_CYCLE, false));
        Data.getInstance().setMinecraftSecond(72.0f);

        Data.getInstance().syncWorldTime();
        Data.getInstance().adjTask.runTaskTimer(this, 1L, 1200L);
        getLogger().info("Finished Tokei Plugin");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Shutting Down Tokei Plugin");
    }
}

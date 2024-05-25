package org.blackteasea.tokeiproject;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.GameRule.DO_DAYLIGHT_CYCLE;

public final class TokeiProject extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Data.getInstance().setJavaPlugin(this);

        //Obtain worldlist to manipulate
        Data.getInstance().setWorldList(getServer().getWorlds());

        //GAMERULES
        //Stops the daylight cycle for all worlds
        getServer().getWorlds().forEach(world -> world.setGameRule(DO_DAYLIGHT_CYCLE, false));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

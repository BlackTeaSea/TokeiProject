package org.blackteasea.tokeiproject;

import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.GameRule.DO_DAYLIGHT_CYCLE;

public final class TokeiProject extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Data.getInstance().setJavaPlugin(this);

        //Stops the daylight cycle
        getServer().getWorlds().forEach(world -> world.setGameRule(DO_DAYLIGHT_CYCLE, false));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

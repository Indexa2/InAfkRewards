package com.index.InAfkReward; 

import org.bukkit.Location; 
import org.bukkit.configuration.file.FileConfiguration; 

public class AfkRegionManager {

    private final Location afkLocation; 
    private final double radius; 

    public AfkRegionManager() {
        FileConfiguration config = AfkRewards.getInstance().getConfig();

        double x = config.getDouble("afk-region.x");
        double y = config.getDouble("afk-region.y");
        double z = config.getDouble("afk-region.z");
        String worldName = config.getString("afk-region.world");
        radius = config.getDouble("afk-region.radius");

        afkLocation = new Location(AfkRewards.getInstance().getServer().getWorld(worldName), x, y, z);
    }

    public boolean isPlayerInAfkRegion(Location playerLocation) {
        return playerLocation.getWorld().equals(afkLocation.getWorld()) &&
               playerLocation.distance(afkLocation) <= radius; 
    }
}

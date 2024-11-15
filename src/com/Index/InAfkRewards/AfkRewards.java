package com.index.InAfkRewards; 

import org.bukkit.plugin.java.JavaPlugin;

public class AfkRewards extends JavaPlugin {

    private static AfkRewards instance;
    private AfkRegionManager AfkRegionManager; 
    private RewardHandler rewardhandler;

    @Override
    public void onEnable() {
        instance = this; 
        saveDefaultConfig();

        akRegionManager = new AfkRegionManager(this)
        rewardhandler = new RewardHandler(this); 

        getServer().getPluginManager().registerEvents(new PlayerAFKListener(this), this);
    }

    public static AfkRewards getInstance() {
        return instance; 
    }

    public AfkRegionManager getAfkRegionManager() {
        return AfkRegionManager; 
    }

    public RewardHandler getRewardHandler() {
        return rewardhandler;
    }
}

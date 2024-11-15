package com.index.InAfkRewards.listeners;

import com.index.InAfkReward.InAfkReward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerAFKListener implements Listener {

    public PlayerAFKListener() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (AfkRewards.getInstance().getAfkRegionManager().isPlayerInAfkRegion(player.getLocation())) {
                        AfkRewards.getInstance().getRewardHandler().giveReward(player);
                    }
                }
            }
        }.runTaskTimer(AfkRewards.getInstance(), 0, AfkRewards.getInstance().getRewardHandler().getRewardInterval() * 20L);
    }
}

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this; 
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceholderExpansion().register();
            getLogger().info("PlaceholderAPI hook registered!");
        } else {
            getLogger().warning("PlaceholderAPI not found! Placeholder functionality will be disabled.");
        }
    }

    @Override
    public void onDisable() {
        instance = null; 
    }

    public static Main getInstance() {
        return instance; 
    }
}

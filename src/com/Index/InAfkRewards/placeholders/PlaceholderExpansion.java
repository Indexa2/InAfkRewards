import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderExpansion extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "inafkrewards"; 
    }

    @Override
    public @NotNull String getAuthor() {
        return "Index"; 
    }

    @Override
    public @NotNull String getVersion() {
        return "0.2";
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return "";
        }
 
        if (params.equalsIgnoreCase("time")) {
            return String.valueOf(Main.getInstance().getAfkTime(player)); 
        }

        if (params.equalsIgnoreCase("reward")) {
            return Main.getInstance().getNextReward(player); 
        }

        return null; 
    }
}

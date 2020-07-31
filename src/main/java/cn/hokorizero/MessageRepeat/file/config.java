package cn.hokorizero.MessageRepeat.file;

import cn.hokorizero.MessageRepeat.MessageRepeat;
import org.bukkit.configuration.file.FileConfiguration;

public class config {

    private static FileConfiguration config = MessageRepeat.getInstance().getConfig();

    public static void loadConfig() {
        MessageRepeat.getInstance().reloadConfig();
        config = MessageRepeat.getInstance().getConfig();
    }
}

package cn.hokorizero.MessageRepeat.Listener;

import cn.hokorizero.MessageRepeat.MessageRepeat;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(MessageRepeat.getInstance().getConfig().getBoolean("config",true)){
            Set<String> list = MessageRepeat.instance.getConfig().getConfigurationSection("message").getKeys(false);
            list.forEach(m -> {
                if (e.getMessage().equalsIgnoreCase(m)) {
                    Bukkit.getScheduler().runTaskLater(MessageRepeat.instance, () -> {
                        Bukkit.broadcastMessage("§"+MessageRepeat.getInstance().getConfig().getString("color") + MessageRepeat.getInstance().getConfig().getString("message." + m));
                    }, 20L);
                }
            });
        }
    }
}




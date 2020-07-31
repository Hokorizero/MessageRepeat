package cn.hokorizero.MessageRepeat;

import cn.hokorizero.MessageRepeat.Listener.AsyncPlayerChatListener;
import cn.hokorizero.MessageRepeat.command.commandexecutor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class MessageRepeat extends JavaPlugin {
    public static MessageRepeat instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance=this;


        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage("§3[Testplugin]插件已安装成功");
        Bukkit.getPluginCommand("msrepeat").setExecutor(new commandexecutor());
        Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static MessageRepeat getInstance() {
        return instance;
    }
}

package cn.hokorizero.MessageRepeat.command;

import cn.hokorizero.MessageRepeat.MessageRepeat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cn.hokorizero.MessageRepeat.file.config.loadConfig;


public class commandexecutor implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        int i = 10;
        double b = 20;

        if (cmd.getName().equalsIgnoreCase("msrepeat")) {

            if (!(sender instanceof Player)) {
                sender.sendMessage("You must be a player!");
                return true;
            }

            Player player = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage("§a------[msrepeat]指令集------");
                sender.sendMessage("§a/msrepeat help 查看帮助信息");
                return true;
            }
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("§a/msrepeat help 查看帮助信息");
                sender.sendMessage("§a/msrepeat reload 重载配置文件");
                sender.sendMessage("§a/msrepeat on 开启/关闭关键词回复功能");


                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("msrepeat.reload") || sender.isOp()) {
                    loadConfig();
                    sender.sendMessage("§a[msrepeat]插件已经重载成功");
                } else {
                    sender.sendMessage("§a[msrepeat]你没有使用此命令的权限");
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("on")) {
                if (sender.hasPermission("msrepeat.on") || sender.isOp()) {
                    if (MessageRepeat.getInstance().getConfig().getBoolean("config",true)) {
                        MessageRepeat.getInstance().getConfig().set("config", false);
                        MessageRepeat.getInstance().saveConfig();
                        sender.sendMessage("§b关键词回复功能已经关闭");
                    } else  {
                        MessageRepeat.getInstance().getConfig().set("config", true);
                        MessageRepeat.getInstance().saveConfig();
                        sender.sendMessage("§b关键词回复功能已经开启");
                    }
                } else {
                    sender.sendMessage("§a[msrepeat]你没有使用此命令的权限");
                }
                return true;
            }

        }
        return true;
    }
}

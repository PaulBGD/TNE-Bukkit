package net.tnemc.core.commands.admin;

import net.tnemc.core.TNE;
import net.tnemc.core.commands.TNECommand;
import net.tnemc.core.common.utils.MISCUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.io.File;

/**
 * The New Economy Minecraft Server Plugin
 *
 * This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ or send a letter to
 * Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
 * Created by Daniel on 2/8/2018.
 */
public class AdminRestoreCommand implements CommandExecution {

  public AdminRestoreCommand(TNE plugin) {
    super(plugin);
  }

  @Override
  public String name() {
    return "restore";
  }

  @Override
  public String[] aliases() {
    return new String[0];
  }

  @Override
  public String node() {
    return "tne.admin.restore";
  }

  @Override
  public boolean console() {
    return true;
  }

  @Override
  public String helpLine() {
    return "Messages.Commands.Admin.Restore";
  }

  @Override
  public boolean execute(CommandSender sender, Command command, String label, String[] arguments) {
    File file = new File(TNE.instance().getDataFolder(), "extracted.yml");
    if(file.exists()) {
      Bukkit.getScheduler().runTaskAsynchronously(TNE.instance(), () -> MISCUtils.restore(sender));
      return true;
    }
    sender.sendMessage(ChatColor.RED + "Unable to locate extracted.yml file for restoration.");
    return false;
  }
}
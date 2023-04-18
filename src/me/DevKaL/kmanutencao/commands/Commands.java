package me.DevKaL.kmanutencao.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.DevKaL.kmanutencao.main.Main;
import me.DevKaL.kmanutencao.util.ActionBarAPI;
import me.DevKaL.kmanutencao.util.TitleAPI;

public class Commands implements CommandExecutor {

	private final Main plugin = Main.getMain();
	
	public static String getText(int init, String... args) {		
		StringBuilder text = new StringBuilder();
		int id = 0;
		for (String arg : args) {
			if (id < init) {
				id++;
				continue;
			}
			text.append(" " + arg);
			id++;
		}
		return text.toString();
	}
	

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("manutencao")) {
			if (!sender.hasPermission("manutencao.usar")) {
				sender.sendMessage("Sem permissão.");
				return true;
			}
		}

		if (args.length == 0) {
			sender.sendMessage("§a/manutencao help");
			return true;
		}

		if ((args[0].equalsIgnoreCase("help")) || (args[0].equalsIgnoreCase("ajuda"))) {
			sender.sendMessage("§a/manu start - Para iniciar a manutencao.");
			sender.sendMessage("§a/manu stop - Para finalizar a manutencao.");
			sender.sendMessage("§a/manu aviso - Envia um título ao servidor.");
			return true;
		}

		if ((args[0].equalsIgnoreCase("start")) || (args[0].equalsIgnoreCase("iniciar"))) {
			
			
			plugin.getConfig().set("Manutencao.Situacao", true);
			plugin.saveConfig();
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (!player.hasPermission("manutencao.bypass")) {
					player.kickPlayer(plugin.getConfig().getString("Mensagem.Kick").replace("&", "§")
							.replace("%linha%", "\n"));
				}
			}
			sender.sendMessage("§cManutencao ativada!");
			return true;
		}

		if ((args[0].equalsIgnoreCase("stop")) || (args[0].equalsIgnoreCase("parar"))) {
			plugin.getConfig().set("Manutencao.Situacao", false);
			plugin.saveConfig();
			sender.sendMessage("§aManutencao desativada!");
			return true;
		}
		if (args.length < 2) {
			sender.sendMessage("§aUse /manu aviso <Title> <SubTitle/Texto>");
			sender.sendMessage("§aAjuste o tempo de duração na config.yml");
			return true;
		} else {
			if (args[0].equalsIgnoreCase("aviso")) {

				String texto = getText(2, args);
				for (Player player : Bukkit.getOnlinePlayers()) {
					TitleAPI.sendTitle(player, plugin.getConfig().getInt("AvisoManutencao.Fadein") * 20, plugin.getConfig().getInt("AvisoManutencao.Stay") * 20, 
					plugin.getConfig().getInt("AvisoManutencao.FadeOut") * 20, args[1].replaceAll("&", "§"), texto.replaceAll("&", "§"));
					
					ActionBarAPI.sendActionBar(player, texto.replaceAll("&", "§"));
				}
				return true;
			}
		}
		return false;
	}

}

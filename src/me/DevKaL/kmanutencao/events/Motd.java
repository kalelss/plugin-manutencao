package me.DevKaL.kmanutencao.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import me.DevKaL.kmanutencao.main.Main;

public class Motd implements Listener {

	private final Main instance = Main.getMain();

	@EventHandler
	public void motd(ServerListPingEvent e) {
		if (!instance.getConfig().getBoolean("Manutencao.Situacao")) {
			String motd1 = instance.getConfig().getString("Server-MOTD.Linha-1").replace("&", "�");
			String motd2 = instance.getConfig().getString("Server-MOTD.Linha-2").replace("&", "�");
			int maxplayers = instance.getConfig().getInt("Server-MOTD.Max-Players");
			e.setMotd(motd1 + '\n' + motd2);
			e.setMaxPlayers(maxplayers);
		} else {
			String motd1 = instance.getConfig().getString("Manutencao-MOTD.Linha-1").replace("&", "�");
			String motd2 = instance.getConfig().getString("Manutencao-MOTD.Linha-2").replace("&", "�");
			int maxplayers = instance.getConfig().getInt("Manutencao-MOTD.Max-Players");
			e.setMotd(motd1 + '\n' + motd2);
			e.setMaxPlayers(maxplayers);
		}
	}
}

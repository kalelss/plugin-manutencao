package me.DevKaL.kmanutencao.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.DevKaL.kmanutencao.main.Main;


public class Entrar implements Listener{
	
	private final Main plugin = Main.getMain();
	
	@EventHandler
		public void aoLogar(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(plugin.getConfig().getBoolean("Manutencao.Situacao")){
				if(p.hasPermission("manutencao.bypass")){
					p.sendMessage(plugin.getConfig().getString("Mensagem.Entrada").replace("&", "§").replace("%linha%", "\n"));
				}else {
					p.kickPlayer(plugin.getConfig().getString("Mensagem.Login").replace("&", "§").replace("%linha%", "\n"));
	            }
		    }	
       }
}


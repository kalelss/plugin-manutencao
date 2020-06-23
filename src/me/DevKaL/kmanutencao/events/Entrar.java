package me.DevKaL.kmanutencao.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import me.DevKaL.kmanutencao.main.Main;


public class Entrar implements Listener{
	
	private final Main instance = Main.getMain();
	@EventHandler
		public void aoLogar(PlayerJoinEvent e){
		Player p = e.getPlayer();
			if(instance.getConfig().getBoolean("Manutencao.Situacao")){
				if(p.hasPermission("manutencao.bypass")){
					p.sendMessage(instance.getConfig().getString("Mensagem.Entrada").replace("&", "§").replace("%linha%", "\n"));
				}else {
					p.kickPlayer(instance.getConfig().getString("Mensagem.Login").replace("&", "§").replace("%linha%", "\n"));
	            }
		    }
       }
}


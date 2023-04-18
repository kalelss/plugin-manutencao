package me.DevKaL.kmanutencao.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import me.DevKaL.kmanutencao.commands.Commands;
import me.DevKaL.kmanutencao.events.Entrar;
import me.DevKaL.kmanutencao.events.Motd;


public class Main extends JavaPlugin{

	
	public void onEnable() {
		
		getServer().getPluginCommand("manutencao").setExecutor(new Commands());
		getServer().getPluginManager().registerEvents(new Entrar(), this);
		getServer().getPluginManager().registerEvents(new Motd(), this);
		
		if(!new File(getDataFolder(),"config.yml").exists()) {
			saveDefaultConfig();
			saveConfig();
		}
		
		getServer().getConsoleSender().sendMessage("§a[K-Manutencao] ============================");
		getServer().getConsoleSender().sendMessage("§a[K-Manutencao] Iniciado com sucesso!");
	    getServer().getConsoleSender().sendMessage("§a[K-Manutencao] Versao: " + getDescription().getVersion());
	    getServer().getConsoleSender().sendMessage("§a[K-Manutencao] Autor: " + getDescription().getAuthors());
	    getServer().getConsoleSender().sendMessage("§a[K-Manutencao] Iniciado com sucesso!");
		getServer().getConsoleSender().sendMessage("§a[K-Manutencao] ============================");
	}	
	

	public void onDisable() {
		
		HandlerList.unregisterAll();
		
		getServer().getConsoleSender().sendMessage("§c[K-Manutencao] =============================");
		getServer().getConsoleSender().sendMessage("§c[K-Manutencao] Finalizado com sucesso!");
		getServer().getConsoleSender().sendMessage("§c[K-Manutencao] =============================");
	
	}
	
	public static Main getMain() {
		return (Main) Bukkit.getPluginManager().getPlugin("K-Manutencao");
	}
	
}

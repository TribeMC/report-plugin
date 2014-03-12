package V3Rep;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class join implements Listener{

	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PostLoginEvent e){
		if(e.getPlayer().getName().contains(" ") || e.getPlayer().getName().contains("ä") || e.getPlayer().getName().contains("ü") || e.getPlayer().getName().contains("ö")){
			e.getPlayer().disconnect("§cDer Name ist ungültig!");
		}
		if(ProxyServer.getInstance().getOnlineCount() > main.maxJoins){
			net.md_5.bungee.config.Configuration cfg;
			try {
				cfg = ConfigurationProvider
						.getProvider(YamlConfiguration.class).load(
								new File("plugins/Reports", "config.yml"));
				cfg.set("Joins", ProxyServer.getInstance().getOnlineCount() + 1);
				main.maxJoins = ProxyServer.getInstance().getOnlineCount() + 1;
				ConfigurationProvider.getProvider(YamlConfiguration.class).save(
						cfg, new File("plugins/Reports", "config.yml"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	
	
	
}

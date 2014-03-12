package V3Rep;

import java.util.concurrent.TimeUnit;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.command.ConsoleCommandSender;

public class SaveStop extends Command{

	Plugin pl;
	public SaveStop(String name, main main) {
		super(name);
		 pl = main;
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender cs, String[] arg1) {
		// TODO Auto-generated method stub
		if(cs instanceof ConsoleCommandSender){
			cs.sendMessage("§eServer wird in §c2 §eMinuten gestoppt!");
			stopProxy();
		}else{
			cs.sendMessage("§cDies kann nur die Konsole machen!");
		}
	}
	
	public void stopProxy() {

		
		brodcast(120);
		
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				brodcast(60);

				
			}
		}, 60, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				brodcast(30);
			}
		}, 90, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				brodcast(15);
			}
		}, 105, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				brodcast(10);
			}
		}, 110, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				brodcast(5);
			}
		}, 115, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				brodcast(2);
			}
		}, 118, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				kickAll();
			}

			@SuppressWarnings("deprecation")
			private void kickAll() {
				// TODO Auto-generated method stub
				for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
					p.disconnect("§b=-=-=-=-=-=-=-=-=-=-=-= \n§cDas §6Netzwerk §cwird neu gestartet!\n§b=-=-=-=-=-=-=-=-=-=-=-=");
				}
			}
		}, 120, TimeUnit.SECONDS);
		ProxyServer.getInstance().getScheduler().schedule(pl, new Runnable() {
			public void run() {
				ProxyServer.getInstance().stop();
			}
		}, 122, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	private static void brodcast(int i) {
		// TODO Auto-generated method stub
		ProxyServer.getInstance().broadcast(
				"§b[§6Netzwerk§b] §cNeustart §7in §c" + i + "§7Sekunden!");
	}


}

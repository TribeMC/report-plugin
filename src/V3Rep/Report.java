package V3Rep;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Report implements Listener {

	@SuppressWarnings("deprecation")
	public static void addReport(ProxiedPlayer p, String tar, String cause,
			String beweis) {

		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));

			List<String> re = cfg.getStringList("Reports");

			cause = cause.replaceAll("=-=", "=");
			beweis = beweis.replaceAll("=-=", "=!=");
			tar = tar.replaceAll("=-=", "=");
			int count = re.size();
			re.add(count + "=-=" + "Open" + "=-=" + p.getName().toLowerCase()
					+ "=-=" + tar.toLowerCase() + "=-=" + cause + "=-="
					+ beweis);
			cfg.set("Reports", re);

			ConfigurationProvider.getProvider(YamlConfiguration.class).save(
					cfg, new File("plugins/Reports", "config.yml"));
			getReportFromInt(p, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");
		}
		
		

	}

	@SuppressWarnings("deprecation")
	public static void getReportFromInt(ProxiedPlayer p, int count) {
		// TODO Auto-generated method stub
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			if (re.size() -1 < count) {
				p.sendMessage("§7Konnte §ckeinen §7Report finden!");

				return;
			}
			String cur = re.get(count);

			String[] c = cur.split("=-=");
			int num = Integer.valueOf(c[0]);
			String status = c[1];
			String repper = c[2];
			String target = c[3];
			String cause = c[4];
			String beweis = c[5];

			p.sendMessage("§7Details von Report §c" + num + "§7:");
			p.sendMessage("§7Status: §b" + status);
			p.sendMessage("§7Reportet von: §6" + repper);
			p.sendMessage("§7Report über: §6" + target);
			p.sendMessage("§7Grund: §c" + cause);
			p.sendMessage("§7Beweis: §8" + beweis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
		
		

	}

	@SuppressWarnings("deprecation")
	public static void changeStatus(ProxiedPlayer p, int count) {
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			if (re.size() -1 < count) {
				p.sendMessage("§7Konnte §ckeinen §7Report finden!");

				return;
			}
			String cur = re.get(count);

			String[] c = cur.split("=-=");
			int num = Integer.valueOf(c[0]);
			String status = c[1];
			String repper = c[2];
			String target = c[3];
			String cause = c[4];
			String beweis = c[5];

			status = "Done by " + p.getName();

			re.set(count, num + "=-=" + status + "=-=" + repper + "=-="
					+ target + "=-=" + cause + "=-=" + beweis);
			cfg.set("Reports", re);

			ConfigurationProvider.getProvider(YamlConfiguration.class).save(
					cfg, new File("plugins/Reports", "config.yml"));
			getReportFromInt(p, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
	}

	@SuppressWarnings("deprecation")
	public static void getOwnReports(ProxiedPlayer p) {
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			p.sendMessage("§7Deine Reports:");
			for (String cur : re) {
				String[] c = cur.split("=-=");

				if (c[2].equalsIgnoreCase(p.getName())) {

					shortOutPut(p, Integer.valueOf(c[0]));
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
	}
	
	@SuppressWarnings("deprecation")
	public static void getReportsFrom(ProxiedPlayer p, String p1) {
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			for (String cur : re) {
				String[] c = cur.split("=-=");

				if (c[2].equalsIgnoreCase(p1)) {

					shortOutPut(p, Integer.valueOf(c[0]));
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
	}
	
	@SuppressWarnings("deprecation")
	public static void getReportsOver(ProxiedPlayer p, String p1) {
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			for (String cur : re) {
				String[] c = cur.split("=-=");

				if (c[3].equalsIgnoreCase(p1)) {

					shortOutPut(p, Integer.valueOf(c[0]));
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
	}

	@SuppressWarnings("deprecation")
	public static void shortOutPut(ProxiedPlayer p, int count) {
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			if (re.get(count) == null) {
				p.sendMessage("§7Konnte §ckeinen §7Report finden!");

				return;
			}
			String cur = re.get(count);

			String[] c = cur.split("=-=");
			int num = Integer.valueOf(c[0]);
			String status = c[1];
			String target = c[3];
			String cause = c[4];
			p.sendMessage("§e" + num + "§7: §c" + target + "§7 wurde wegen §c"
					+ cause + "§7 reportet! §8(§b" + status + "§8)");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
	}

	@SuppressWarnings("deprecation")
	public static void openOutPut(ProxiedPlayer p) {
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			List<String> re = cfg.getStringList("Reports");
			int i = 0;
			int ii = 0;
			ArrayList<String> in = new ArrayList<>();
			while (i < 10 && ii < re.size()) {
				String cur = re.get(ii);
				ii++;

				String[] c = cur.split("=-=");
				if (c[1].equalsIgnoreCase("Open")) {
					i++;
					in.add(c[0]);
				}
			}
			p.sendMessage("§7Zu bearbeitende Reports:");
			for (String s : in) {
				
				shortOutPut(p, Integer.valueOf(s));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			p.sendMessage("§cVersuche es später erneut!");

		}
	}

	public static boolean canReadRepport(ProxiedPlayer p, int count){
		if(main.rep.contains(p.getName())){
			return true;
		}else{
			
			try {
				net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
						.getProvider(YamlConfiguration.class).load(
								new File("plugins/Reports", "config.yml"));
				List<String> re = cfg.getStringList("Reports");
				
				String cur = re.get(count);
				String[] c = cur.split("=-=");

				if(c[2].equals(p.getName())){
					
					return true;
					
				}else{
				
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			}
			
		
		}
		
		
	}

	public static boolean isCause(String cause) {
		if (cause.equalsIgnoreCase("doppelacc")
				|| cause.equalsIgnoreCase("dacc")
				|| cause.equalsIgnoreCase("doppelaccount")) {
			return true;
		} else if (cause.equalsIgnoreCase("hack")
				|| cause.equalsIgnoreCase("hacks")) {
			return true;
		} else if (cause.equalsIgnoreCase("chat")
				|| cause.equalsIgnoreCase("chatvergehen")
				|| cause.equalsIgnoreCase("beleidigung")) {
			return true;
		} else if (cause.equalsIgnoreCase("other")) {
			return true;
		} else {
			return false;
		}
	}

}

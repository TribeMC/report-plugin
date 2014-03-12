package V3Rep;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class main extends Plugin {

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		setRep();
		getProxy().getPluginManager().registerCommand(this,
				new reportCMD("report"));
		getProxy().getPluginManager().registerCommand(this,
				new myReportsCMD("myreports"));
		getProxy().getPluginManager().registerCommand(this,
				new getReportsCMD("getreports"));
		getProxy().getPluginManager().registerCommand(this,
				new MaxONCMD("maxon"));
		getProxy().getPluginManager().registerCommand(this,
				new SaveStop("stop", this));

		
		getProxy().getPluginManager().registerListener(this, new join());
		File fdir = new File("plugins/Reports");
		if (!fdir.exists()) {
			fdir.mkdir();
		}
		File f = new File("plugins/Reports", "config.yml");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			net.md_5.bungee.config.Configuration cfg = ConfigurationProvider
					.getProvider(YamlConfiguration.class).load(
							new File("plugins/Reports", "config.yml"));
			maxJoins = cfg.getInt("Joins");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onEnable();
	}

	public static int maxJoins;

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}

	static ArrayList<String> rep = new ArrayList<>();

	public void setRep() {
		rep.add("V3lop5");
		rep.add("callee28");
		rep.add("gammar111");
		rep.add("MiroLPM");
		rep.add("Monk_Key");

	}

	
	
	

}

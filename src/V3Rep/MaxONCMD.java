package V3Rep;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class MaxONCMD extends Command{

	public MaxONCMD(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender cs, String[] arg1) {
		// TODO Auto-generated method stub
		cs.sendMessage("§7Auf §1TRIBE §7waren §e" + main.maxJoins + "§7 User gleichzeitig Online!");
	}

}

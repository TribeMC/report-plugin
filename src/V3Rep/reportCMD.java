package V3Rep;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class reportCMD extends Command{

	public reportCMD(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender cs, String[] args) {
		// TODO Auto-generated method stub
		if(cs instanceof ProxiedPlayer){
			if(args.length == 1 && args[0].equalsIgnoreCase("help")){
				cs.sendMessage("§7Hilfe zu den §1Tribe §7Reports:");
				cs.sendMessage("");
				cs.sendMessage("§7Nutze: §c/report [Spieler] [Grund] [Beweis]");
				cs.sendMessage("§7Mithilfe von Beweisen geht die Bearbeitung von Reports schneller!");
				cs.sendMessage("§7Um deine Reports einzusehen, Nutze §c/myreports");
				cs.sendMessage("§7Um Details zu deinen Reports einzusehen, Nutze §c/myreports [ReportID]");

			}else
			if(args.length >= 2){
				ProxiedPlayer p = (ProxiedPlayer) cs;
				if(Report.isCause(args[1])){
					String beweis = "Keinen";
					if(args.length >= 3){
						beweis = "";
						for(int i = 2; i < args.length; i++){
							beweis = beweis + args[i] + " ";
						}
					}
				Report.addReport(p, args[0], args[1], beweis);
				}else{
					p.sendMessage("§cDies ist kein Grund!");
					p.sendMessage("§7Gründe: doppelaccount, Hacks, Beleidigung, Other");
				}
			}else{
				cs.sendMessage("§7Nutze: §c/report help");
			}
		}else{
			cs.sendMessage("Bann doch direkt du Hacker!");
		}
	}

}

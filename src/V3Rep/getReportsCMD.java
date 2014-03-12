package V3Rep;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class getReportsCMD extends Command {

	public getReportsCMD(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender cs, String[] args) {
		// TODO Auto-generated method stub
		if (cs instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) cs;
			if (main.rep.contains(p.getName())) {
				if (args.length == 0) {
					Report.openOutPut(p);
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("help")) {

						p.sendMessage("§7Hilfe zu Reports:");
						p.sendMessage("§7Um offene Reports zu sehen, Nutze: §c/getreports");
						p.sendMessage("§7Für Details zu einem Report, Nutze: §c/getreports [ReportID]");
						p.sendMessage("§7Um einen Report zu bearbeiten, Nutze: §c/getreports [ReportID] done");
						p.sendMessage("§7Um Reports von einem Spieler zu sehen, Nutze §c/getreports from [Spieler]");
						p.sendMessage("§7Um Reports über einen Spieler zu sehen, Nutze §c/getreports over [Spieler]");
					} else {
						int i = 0;
						try {
							i = Integer.valueOf(args[0]);
						} catch (Exception e) {
							p.sendMessage("§7Keine gültige ReportID!");
							return;
						}
						Report.getReportFromInt(p, i);
					}
				} else if (args.length == 2) {
					if (args[0].equalsIgnoreCase("from")) {

						p.sendMessage("§7Reports von dem Spieler §6"+args[1]+ "§7:");
						Report.getReportsFrom(p, args[1]);
					} else if (args[0].equalsIgnoreCase("get") || args[0].equalsIgnoreCase("over")) {
						p.sendMessage("§7Reports über den Spieler §6"+args[1]+ "§7:");
						Report.getReportsOver(p, args[1]);
					}else{
						int i = 0;
						try {
							i = Integer.valueOf(args[0]);
						} catch (Exception e) {
							p.sendMessage("§7Keine gültige ReportID!");
							return;
						}

						if (args[1].equalsIgnoreCase("done")) {
							Report.changeStatus(p, i);
						} else {
							cs.sendMessage("§7Nutze: §c/getreport [ReportID] done §7oder §c/getreport [ReportID]");

						}
					}
				} else {

					cs.sendMessage("§7Nutze: §c/getreport help");
				}
			} else {
				p.sendMessage("§cDazu hast du keine Rechte!");
			}
		} else {
			cs.sendMessage("Only Player");
		}
	}
}

package V3Rep;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class myReportsCMD extends Command{

	public myReportsCMD(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender cs, String[] args) {
		// TODO Auto-generated method stub
		if(cs instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) cs;
			if(args.length == 0){
				Report.getOwnReports(p);
			}else
			if(args.length == 1){
				int i = 0;
				try{
					i = Integer.valueOf(args[0]);
				}catch(Exception e){
					p.sendMessage("§7Keine gültige ReportID!");
					return;
				}
				if(Report.canReadRepport(p, i)){
					Report.getReportFromInt(p, i);
				}else{
					p.sendMessage("§7Dies ist nicht dein Report!");
					
				}
			}else{
				p.sendMessage("§7Nutze: §c/myreports §7oder §c/myreports [ReportID]");
			}
			
		}else{
			cs.sendMessage("Du hast keine Reports");
		}
	}

}

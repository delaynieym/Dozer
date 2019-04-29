import java.util.List;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ListRoles extends ListenerAdapter {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Bot.prefix + "list")) {
//			List<Role> roles = event.getGuild().getRoles();
//			String list = "```" + roles.get(0).getName();
//			
//			for (int i = 1; i < roles.size() - 1; i++) {
//				if(!roles.get(i).getName().contains("@")) {
//					list += " \n" + roles.get(i).getName();
//				}
//			}
//			
//			list += roles.get(roles.size() - 1).getName() + "```";
//			System.out.println(list);
//			
//			event.getChannel().sendMessage(list).queue();
			
			List<Role> roles = event.getGuild().getRoles();
			String msg = "```";
			for (Role r : roles) {
				String roleName = r.getName();
				if (!roleName.contains("@")) {
					msg += roleName + "\n";
				}
			}
			msg += "```";
			event.getChannel().sendMessage(msg).queue();
		}
	}

}

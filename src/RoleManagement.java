import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class RoleManagement extends ListenerAdapter{
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Bot.prefix + "role") && args.length > 2) {
			String role = "";
			for (int i = 2; i < args.length; i++) {
				role += args[i];
				if (i < args.length - 1) role += " ";
			}
			
			if (args[1].equalsIgnoreCase("add")) {
				event.getGuild().getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName(role, true)).complete();
			}
			
			if (args[1].equalsIgnoreCase("remove")) {
				event.getGuild().getController().removeRolesFromMember(event.getMember(), event.getJDA().getRolesByName(role, true)).complete();
			}
		}
	}
}

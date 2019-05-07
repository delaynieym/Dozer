import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GiveRole extends ListenerAdapter{
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Member member = event.getMember();
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
// parsing request
		if (args[0].equalsIgnoreCase(Bot.prefix + "give") && args.length > 1) {
			String request = "";
			for (int i = 1; i < args.length; i++) {
				request += args[i];
				if (i < args.length - 1) request += " ";
			}
			
// getting the Role
			Role role = null;
			try {
				role = event.getJDA().getRolesByName(request, true).get(0);
			}
			catch (Exception e) {
				event.getChannel().sendMessage("Exception: " + e).queue();
			}
			
			if (role.hasPermission(Permission.ADMINISTRATOR) && !member.hasPermission(Permission.ADMINISTRATOR)) {
				event.getChannel().sendMessage("sorry " + member.getAsMention() + ", you don't have permission to hold that role").queue();
			}
			
			event.getGuild().getController().addRolesToMember(member, role).complete();
			event.getChannel().sendMessage(member.getAsMention() + " role successfully added").queue();

		}
	}
}

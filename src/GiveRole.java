import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GiveRole extends ListenerAdapter{
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(Bot.prefix + "give") && args.length > 1) {
			String role = "";
			for (int i = 1; i < args.length; i++) {
				role += args[i];
				if (i < args.length - 1) role += " ";
			}
			
			try {
				event.getGuild().getController().addRolesToMember(event.getMember(), event.getJDA().getRolesByName(role, true)).complete();
			}
			catch (Exception e) {
				event.getChannel().sendMessage("Exception: " + e).queue();
			}
		}
	}
}

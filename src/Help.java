import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");

		if (args[0].equalsIgnoreCase(Bot.prefix + "help")) {
			EmbedBuilder commands = new EmbedBuilder();
			commands.setTitle("Commands");
			commands.setColor(0xff0000);
			commands.addField("get a role", "`r!give <role>`", false);
			commands.addField("remove a role", "`r!remove <role>`", false);
			commands.addField("list all roles", "`r!list`", false);

			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(commands.build()).queue();
			commands.clear();
		}
	}
}

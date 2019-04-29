import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class MessageListener extends ListenerAdapter
{
    public static void main(String[] args)
            throws LoginException
    {
        JDA jda = new JDABuilder("NTYwNTg3OTkwNDU2MzM2NDI0.XMJ2BQ.s_obbM2UtPngDpMS_msT8-AfYsc").build();
        jda.addEventListener(new MessageListener());
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
            System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                    event.getChannel().getName(), event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
        }

}
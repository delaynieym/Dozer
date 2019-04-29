import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Role;

public class Bot {
	public static JDA jda;
	public static String prefix = "r!";
	
	public static void main(String[] args) throws LoginException {
		jda = new JDABuilder(AccountType.BOT).setToken(Secret.token).build();
		//token for role management
		
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setGame(Game.playing("r!help for commands"));

		List<Role> roles = jda.getRoles();
		for (Role r : roles) {
			System.out.println(r.getName());
		}
		
		jda.addEventListener(new Help());
		jda.addEventListener(new GiveRole());
		jda.addEventListener(new RemoveRole());
		jda.addEventListener(new ListRoles());
	}
}

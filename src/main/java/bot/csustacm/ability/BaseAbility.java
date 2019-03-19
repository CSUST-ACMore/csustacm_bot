package bot.csustacm.ability;

import bot.csustacm.Constants;
import org.telegram.abilitybots.api.objects.Ability;

import static bot.csustacm.Main.getBot;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;


public class BaseAbility {

    public static Ability linksAbility = Ability.builder()
            .name("hello")
            .info("hetmdllo")
            .locality(ALL)
            .privacy(PUBLIC)
            .action(ctx -> getBot().sendMessage("Hello......"+ ctx.user().getFirstName(), ctx.chatId()))
            .build();


    public static Ability helloAbility = Ability.builder()
            .name("links")
            .info("获取常用链接")
            .locality(ALL)
            .privacy(PUBLIC)
            .action(ctx -> getBot().sendMessage(Constants.LINKS, ctx.chatId()))
            .build();




}

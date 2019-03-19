package bot.csustacm;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Flag.*;
import static org.telegram.abilitybots.api.objects.Locality.*;
import static org.telegram.abilitybots.api.objects.Privacy.*;

public class MyAbilityBot extends AbilityBot {
    private boolean defaultSwitchOpen = false;
    private boolean recordSwitchOpen = false;

    MyAbilityBot() {
        super(Config.TOKEN, Config.BOT_NAME);
    }

    @Override
    public int creatorId() {
        return new Integer(Config.CREATOR);
    }

    public Ability hello() {
        return Ability.builder()
                .name("hello")
                .info("hello呀")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("Hello......"+ ctx.user().getId(), ctx.chatId()))
                .build();
    }

    public Ability links() {
        return Ability.builder()
                .name("links")
                .info("获取常用链接")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send(Contants.LINKS, ctx.chatId()))
                .build();
    }

    public Ability sayZhengDaLaoTianXiaDiYi(){
        return Ability.builder()
                .name("zdltxdy")
                .info("tqlwsl")
                .locality(ALL)
                .privacy(PUBLIC)
                .action(ctx -> silent.send("政大佬天下第一！", ctx.chatId()))
                .build();
    }

//    public Ability recordNetFriendMessage(){
//        return Ability.builder()
//                .name("record")
//                .info("复读机！")
//                .locality(ALL)
//                .privacy(PUBLIC)
//                .action(ctx -> silent.send())
//    }

    public Ability openBot(){
        return Ability.builder()
                .name("bot")
                .info("Gwolf9！")
                .locality(GROUP)
                .privacy(PUBLIC)
                .action(ctx -> {
                    defaultSwitchOpen = !defaultSwitchOpen;
                    silent.send(defaultSwitchOpen ? "Gwolf9天下第一!" : "溜了嘤嘤嘤", ctx.chatId());
                })
                .build();
    }

    public Ability defalut() {
        return Ability.builder()
                .name(DEFAULT)
                .flag(MESSAGE)
                .privacy(PUBLIC)
                .locality(ALL)
                .action(ctx -> {
                    if (!defaultSwitchOpen) return;
                    silent.send("沙雕网友嗦的什么几把", ctx.chatId());
                })
                .build();
    }
}

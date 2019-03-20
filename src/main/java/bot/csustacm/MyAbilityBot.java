package bot.csustacm;

import bot.csustacm.ability.BaseAbility;
import bot.csustacm.ability.ModDalaoAbility;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static bot.csustacm.Constants.dalaoMap;
import static bot.csustacm.Main.getBot;
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
        return BaseAbility.helloAbility;
    }

    public Ability links() {
        return BaseAbility.linksAbility;
    }

    public Ability sayTianXiaDiYi(){
        return ModDalaoAbility.sayTxdyAbility;
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
                    Update update = ctx.update();
                    if (update.hasMessage()) {
                        Message message = update.getMessage();
                        if (message.hasText()) {
                            String s = message.getText();
                            if (s.contains("Gwolf9")) {
                                sendMessage("Gwolf9天下第一！", ctx.chatId());
                            } else if (dalaoMap.containsKey(s)) {
                                sendMessage(dalaoMap.get(s), ctx.chatId());
                            }
                        }
                    }
                })
                .build();
    }


    public void sendMessage(String msg, long chatId) {
        silent.send(msg, chatId);
    }

}

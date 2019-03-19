package bot.csustacm.ability;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.MessageContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static bot.csustacm.Main.getBot;
import static org.telegram.abilitybots.api.objects.Locality.*;
import static org.telegram.abilitybots.api.objects.Privacy.*;

public class ModDalaoAbility {

    public static Ability sayTxdyAbility = Ability.builder()
            .name("txdy")
            .info("tqlwsl")
            .locality(ALL)
            .privacy(PUBLIC)
            .input(1)
            .action(ctx -> getBot().sendMessage(ctx.firstArg()+"txdy", ctx.chatId()))
            .build();


}

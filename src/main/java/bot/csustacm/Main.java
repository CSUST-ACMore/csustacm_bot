package bot.csustacm;


import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {

    private static MyAbilityBot bot;

    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(getBot());
            System.out.println("Inited...");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    public static MyAbilityBot getBot() {
        if(bot == null) bot = new MyAbilityBot();
        return bot;
    }

}
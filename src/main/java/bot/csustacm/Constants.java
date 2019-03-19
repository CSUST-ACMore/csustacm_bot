package bot.csustacm;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final String LINKS = ""+
            "中文汉化包： t.me/zh_CN\n" +
            "Sticker包制作： @Stickers\n" +
            "Sticker下载： @Stickerdownloadbot\n";

    public static final HashMap<String, String> dalaoMap = new HashMap<String, String>() {
        {
            put("nsa", "xma");
            put("tql", "tttttql");
            put("xma", "nsa");
            put("wsl", "xma");
        }
    };


}

package Commands.keywords;

import Commands.Command;
import VK.VKDataBase;
import VK.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Level extends Command {

    public Level(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        if (name.equals("lvl"))
            new VKManager().sendMessage("Уровень: " + VKDataBase.getLevel(message.getUserId()), message.getUserId());
        if (name.equals("up")) {
            VKDataBase.upLevel(message.getUserId());
            new VKManager().sendMessage("Уровень повышен до " + VKDataBase.getLevel(message.getUserId()) , message.getUserId());
        }

    }
}

package Commands.keywords;

import Commands.Command;
import VK.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Unknown extends Command {

    public Unknown(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("Я ещё не знаю эту команду :с", message.getUserId());
    }
}

package Commands.keywords;

import Commands.Command;
import VK.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class Hello extends Command {

    public Hello(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("Привет, "
                + VKManager.getUserInfo(message.getUserId()).getFirstName(),"photo-198041673_457239018", message.getUserId());
    }
}

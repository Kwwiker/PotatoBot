package Commands;

import Commands.keywords.*;
import VK.VKDataBase;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Collection;

public class CommandDeterminant {

    public static Command getCommand(Collection<Command> commands, Message message) {
        if (!VKDataBase.checkUser(message.getUserId())) {
            VKDataBase.newDialog(message.getUserId());
        }
        String body = message.getBody();
        for (Command command: commands) {
            if (command.name.equals(body.split(" ")[0].toLowerCase())) {
                return command;
            }
        }
        return new Unknown("unknown");
    }
}

package Commands;

import Commands.keywords.*;

import java.util.HashSet;

public class CommandManager {

    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new Unknown("unknown"));
        commands.add(new Hello("привет"));
        commands.add(new Level("lvl"));
        commands.add(new Level("up"));
        commands.add(new Dialog("как"));
        commands.add(new Dialog("плохо"));
        commands.add(new Dialog("хорошо"));
        commands.add(new Dialog("отлично"));
        commands.add(new Dialog("такое"));
        commands.add(new Dialog("help"));
    }

    public static HashSet<Command> getCommands() {
        return commands;
    }

    public static void addCommand(Command command) {
        commands.add(command);
    }
}

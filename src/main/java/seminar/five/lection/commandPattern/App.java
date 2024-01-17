package seminar.five.lection.commandPattern;

import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Command> commands;
    public App(){
        this.commands = new ArrayList<>();
    }
    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void run(){
        for(Command command : commands){
            command.execute();
        }
    }
}

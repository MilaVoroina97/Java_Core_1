package seminar.five.lection.commandPattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Play implements Command{


    private final Speaker speaker;
    @Override
    public void execute() {
        speaker.play();
    }
}

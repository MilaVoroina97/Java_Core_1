package seminar.five.lection.commandPattern;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VolumeDown implements Command{

    private final Speaker speaker;

    @Override
    public void execute() {
        speaker.volumeDown();
    }
}

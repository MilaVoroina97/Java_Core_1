package seminar.three.lection.taskTwo.NewController;

import seminar.three.lection.taskTwo.Interfaces.CheckAnimalCapabilities;
import seminar.three.lection.taskTwo.Model.Animal;
import seminar.three.lection.taskTwo.Model.Bird;

import java.util.List;

public class BirdValidator extends Bird implements CheckAnimalCapabilities {
    @Override
    public boolean checkRunCapabilities(double length) {
        return canDo(length,getRangeRunLength());
    }

    @Override
    public boolean checkSwimCapabilities(double length) {return canDo(length,getRangeSwimLength());}

    @Override
    public boolean checkJumpCapabilities(double height) {
        return canDo(height,getRangeJumpHeight());
    }


}

package seminar.three.lection.taskTwo.NewController;

import seminar.three.lection.taskTwo.Interfaces.CheckAnimalCapabilities;
import seminar.three.lection.taskTwo.Model.Cat;

public class CatValidator extends Cat implements CheckAnimalCapabilities {


    @Override
    public boolean checkRunCapabilities(double length) {
        return canRun(length);
    }

    @Override
    public boolean checkSwimCapabilities(double length) {
        return canSwim(length);
    }

    @Override
    public boolean checkJumpCapabilities(double height) {
        return canJump(height);
    }
}

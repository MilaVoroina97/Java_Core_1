package seminar.three.lection.taskTwo.NewController;

import seminar.three.lection.taskTwo.Interfaces.CheckAnimalCapabilities;
import seminar.three.lection.taskTwo.Model.Animal;
import seminar.three.lection.taskTwo.Model.Cat;

import java.util.List;

public class CatValidator extends Cat implements CheckAnimalCapabilities {


    @Override
    public boolean checkRunCapabilities(double length) {
        return canDo(length,getRangeRunLength());
    }

    @Override
    public boolean checkSwimCapabilities(double length) {
        return false;
    }


    @Override
    public boolean checkJumpCapabilities(double height) {
        return canDo(height,getRangeJumpHeight());
    }


}

package seminar.three.lection.taskTwo.NewController;

import seminar.three.lection.taskTwo.Exceptions.UncorrectAcceptDataRange;
import seminar.three.lection.taskTwo.Interfaces.CheckAnimalCapabilities;
import seminar.three.lection.taskTwo.Model.ActionsType;
import seminar.three.lection.taskTwo.Model.Animal;


public class Validator  {

    private CheckAnimalCapabilities checkAnimalCapabilities;

    public boolean validator(double distance){
        return checkAnimalCapabilities.checkJumpCapabilities(distance);
    }
    public boolean validate(double distance, Animal animal, ActionsType actionsType) {
        try {
            return switch (actionsType) {
                case Run -> animal.canRun(distance);
                case Jump -> animal.canJump(distance);
                case Swim -> animal.canSwim(distance);
            };
        } catch (UncorrectAcceptDataRange ex) {
            throw new UncorrectAcceptDataRange("You should enter length or height in allowed range");
        }

    }

}

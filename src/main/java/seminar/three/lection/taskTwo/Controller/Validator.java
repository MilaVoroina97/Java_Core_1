package seminar.three.lection.taskTwo.Controller;

import seminar.three.lection.taskTwo.Exceptions.UncorrectAcceptDataRange;
import seminar.three.lection.taskTwo.Interfaces.CheckJumpCapability;
import seminar.three.lection.taskTwo.Interfaces.CheckRunCapability;
import seminar.three.lection.taskTwo.Interfaces.CheckSwimCapability;
import seminar.three.lection.taskTwo.Model.*;

import java.util.Collections;

public class Validator implements CheckSwimCapability, CheckJumpCapability, CheckRunCapability {


    public boolean validateCat(double userLengthInput, ActionsType actionType){
        if(actionType.equals(ActionsType.Run)) return checkCatRunCapability(userLengthInput);
        else if(actionType.equals(ActionsType.Jump)) return checkCatJumpCapability(userLengthInput);
        else return checkCatSwimCapability();
    }

    public boolean validateDog(double userLengthInput, ActionsType actionType){
        if(actionType.equals(ActionsType.Run)) return checkDogRunCapability(userLengthInput);
        else if(actionType.equals(ActionsType.Jump)) return checkDogJumpCapability(userLengthInput);
        else return checkDogSwimCapability(userLengthInput);
    }
    public boolean validateBird(double userLengthInput, ActionsType actionType){
        if(actionType.equals(ActionsType.Run)) return checkBirdRunCapability(userLengthInput);
        else if(actionType.equals(ActionsType.Jump)) return checkBirdJumpCapability(userLengthInput);
        else return checkBirdSwimCapability(userLengthInput);
    }


    @Override
    public boolean checkCatJumpCapability(double jumpHeight) {
        if(jumpHeight < Collections.min(Cat.getRangeJumpHeight())
                && jumpHeight > Collections.max(Cat.getRangeJumpHeight())){

            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Cat.getRangeJumpHeight())
            + "to" + Collections.max(Cat.getRangeJumpHeight()));
        }

        return true;
    }

    @Override
    public boolean checkDogJumpCapability(double jumpHeight) {
        if(jumpHeight < Collections.min(Dog.getRangeJumpHeight())
                && jumpHeight > Collections.max(Dog.getRangeJumpHeight())){

            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Dog.getRangeJumpHeight())
                    + "to" + Collections.max(Dog.getRangeJumpHeight()));
        }

        return true;
    }

    @Override
    public boolean checkBirdJumpCapability(double jumpHeight) {
        if(jumpHeight < Collections.min(Bird.getRangeJumpHeight())
                && jumpHeight > Collections.max(Bird.getRangeJumpHeight())){

            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Bird.getRangeJumpHeight())
                    + "to" + Collections.max(Bird.getRangeJumpHeight()));
        }

        return true;
    }

    @Override
    public boolean checkCatRunCapability(double runLength) {
        if(runLength > Collections.min(Cat.getRangeRunLength()) &&
                runLength < Collections.max(Cat.getRangeRunLength())){

            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Cat.getRangeRunLength())
                    + "to" + Collections.max(Cat.getRangeRunLength()));
        }
        return true;
    }

    @Override
    public boolean checkDogRunCapability(double runLength) {
        if(runLength > Collections.min(Dog.getRangeRunLength()) &&
                runLength < Collections.max(Dog.getRangeRunLength())){

            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Dog.getRangeRunLength())
                    + "to" + Collections.max(Dog.getRangeRunLength()));
        }
        return true;
    }

    @Override
    public boolean checkBirdRunCapability(double runLength) {
        if(runLength > Collections.min(Bird.getRangeRunLength()) &&
                runLength < Collections.max(Bird.getRangeRunLength())){

            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Bird.getRangeRunLength())
                    + "to" + Collections.max(Bird.getRangeRunLength()));
        }
        return true;
    }

    @Override
    public boolean checkCatSwimCapability() {
        System.out.println("This cat cannot swim");
        return false;
    }

    @Override
    public boolean checkDogSwimCapability(double swimLength) {
        if(swimLength > Collections.min(Dog.getRangeSwimLength()) &&
                swimLength < Collections.max(Dog.getRangeSwimLength())){
            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Dog.getRangeSwimLength())
                    + "to" + Collections.max(Dog.getRangeSwimLength()));
        }
        return true;
    }

    @Override
    public boolean checkBirdSwimCapability(double swimLength) {

        if(swimLength > Collections.min(Bird.getRangeSwimLength()) &&
                swimLength < Collections.max(Bird.getRangeSwimLength())){
            throw new UncorrectAcceptDataRange("Value should be in range from " + Collections.min(Bird.getRangeSwimLength())
                    + "to" + Collections.max(Bird.getRangeSwimLength()));
        }
        return true;
    }
}

package seminar.three.lection.taskTwo.NewController;

import seminar.three.lection.taskTwo.Exceptions.UncorrectAcceptDataRange;
import seminar.three.lection.taskTwo.Model.*;

import java.util.Collections;

public class Validator {

    public boolean validate(double distance, AnimalType animalType, ActionsType actionsType){

        boolean result = true;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            if(actionsType.equals(ActionsType.Jump))
                result = checkJumpCapability(distance,animalType);
            else if(actionsType.equals(ActionsType.Run))
                result = checkRunCapability(distance,animalType);
            else
                result = checkSwimCapability(distance,animalType);
        }catch (UncorrectAcceptDataRange ex){
            stringBuilder.append("\n");
            stringBuilder.append(ex.getMessage());
        }
        if(!result)
            throw  new UncorrectAcceptDataRange(stringBuilder.toString());
        return result;

    }

    public boolean checkJumpCapability(double jumpHeight, AnimalType animalType){

        if(animalType.equals(AnimalType.Cat))
            return jumpHeight > Collections.min(Cat.getRangeJumpHeight())
                    && jumpHeight < Collections.max(Cat.getRangeJumpHeight());
        else if(animalType.equals(AnimalType.Dog))
            return jumpHeight > Collections.min(Dog.getRangeJumpHeight())
                && jumpHeight < Collections.max(Dog.getRangeJumpHeight());
        else
            return jumpHeight > Collections.min(Bird.getRangeJumpHeight())
                    && jumpHeight < Collections.max(Bird.getRangeJumpHeight());

    }
    public boolean checkRunCapability(double runLength, AnimalType animalType){

        if(animalType.equals(AnimalType.Cat))
            return runLength > Collections.min(Cat.getRangeRunLength())
                    && runLength < Collections.max(Cat.getRangeRunLength());
        else if(animalType.equals(AnimalType.Dog))
            return runLength > Collections.min(Dog.getRangeRunLength())
                    && runLength < Collections.max(Dog.getRangeRunLength());
        else
            return runLength > Collections.min(Bird.getRangeRunLength())
                    && runLength < Collections.max(Bird.getRangeRunLength());

    }
    public boolean checkSwimCapability(double swimLength, AnimalType animalType){
        if(animalType.equals(AnimalType.Cat))
            return false;

        else if(animalType.equals(AnimalType.Dog))
            return swimLength > Collections.min(Dog.getRangeSwimLength())
                    && swimLength < Collections.max(Dog.getRangeSwimLength());
        else
            return swimLength > Collections.min(Bird.getRangeSwimLength())
                    && swimLength < Collections.max(Bird.getRangeSwimLength());
    }
}

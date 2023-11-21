package seminar.three.lection.taskTwo.Controller;

import seminar.three.lection.taskTwo.Exceptions.UncorrectAcceptDataRange;
import seminar.three.lection.taskTwo.Interfaces.CheckJumpCapability;
import seminar.three.lection.taskTwo.Interfaces.CheckRunCapability;
import seminar.three.lection.taskTwo.Interfaces.CheckSwimCapability;

public class Validator implements CheckRunCapability, CheckJumpCapability, CheckSwimCapability {

    public boolean validate(String userChoiceData, double userLengthInput){
        return true;
    }

    @Override
    public boolean checkJumpCapability(double jumpHeight, double minHeight, double maxHeight) {
        try{
            if(jumpHeight > minHeight && jumpHeight < maxHeight) return true;
        }catch (NumberFormatException ex){

            throw new NumberFormatException(String.format("Необходимо ввести дробное или целое положительное число."));
        }
        return false;
    }

    @Override
    public boolean checkRunCapability(double runLength, double minRunLength, double maxRunLength) {
        try{
            if(runLength > minRunLength && runLength < maxRunLength) return true;
        }catch (NumberFormatException ex){

            throw new NumberFormatException(String.format("Необходимо ввести дробное или целое положительное число."));
        }
        return false;
    }

    @Override
    public boolean checkSwimCapability(double swimLength, double minSwimLength, double maxSwimLength) {
        try{
            if(swimLength > minSwimLength && swimLength < maxSwimLength) return true;
        }catch (NumberFormatException ex){

            throw new NumberFormatException(String.format("Необходимо ввести дробное или целое положительное число."));
        }
        return false;
    }
}

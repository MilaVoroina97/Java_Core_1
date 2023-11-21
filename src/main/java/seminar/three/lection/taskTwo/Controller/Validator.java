package seminar.three.lection.taskTwo.Controller;

import seminar.three.lection.taskTwo.Interfaces.CheckJumpCapability;
import seminar.three.lection.taskTwo.Interfaces.CheckRunCapability;
import seminar.three.lection.taskTwo.Interfaces.CheckSwimCapability;
import seminar.three.lection.taskTwo.Model.Animal;
import seminar.three.lection.taskTwo.Model.AnimalType;
import seminar.three.lection.taskTwo.Model.Cat;

import java.util.Collections;

public class Validator implements CheckRunCapability, CheckJumpCapability, CheckSwimCapability {

    public boolean validate(String userChoiceData, double userLengthInput,AnimalType type){
        if(type == AnimalType.Cat){
            for(int i = 0; i < Animal.getActions().size(); i++){
                if(Animal.getActions().get(i).equals("run")){
                    Double maxLength = Collections.max(Cat.getMaxRunLength());
                    Double minLength = Collections.min(Cat.getMaxRunLength());

                    return checkRunCapability(userLengthInput,maxLength,minLength);
                }if(Animal.getActions().get(i).equals("swim")){

//                    Double maxLength = Collections.max(Cat.getMaxSwimLength());
//                    Double minLength = Collections.min(Cat.getMaxSwimLength());
                    System.out.println("Кошка не умеет плавать");
                    return false;
                }
            }
        }
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

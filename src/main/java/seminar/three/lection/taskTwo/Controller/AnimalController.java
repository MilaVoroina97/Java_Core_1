package seminar.three.lection.taskTwo.Controller;

import seminar.three.lection.taskTwo.Model.ActionsType;
import seminar.three.lection.taskTwo.Model.Animal;
import seminar.three.lection.taskTwo.Model.AnimalType;
import seminar.three.lection.taskTwo.Viewer.ConsoleView;
import seminar.three.lection.taskTwo.Viewer.View;

public class AnimalController {
    private View<Animal> view;
    private Validator validator;

    public AnimalController(){
        this.view = new ConsoleView();
        this.validator = new Validator();
    }

    public void validateAnimal(AnimalType animalType, ActionsType actionsType){

        double userInput = view.getUserInput();
        boolean result = true;
        try {
            if(animalType.equals(AnimalType.Cat)){
                 result = validator.validateCat(userInput,actionsType);
                view.showMessage(String.format("%b Cat checked succesfully: ", result));
            }else if(animalType.equals(AnimalType.Dog)){
                 result = validator.validateDog(userInput,actionsType);
                view.showMessage(String.format("%b Dog checked succesfully: ", result));
            }else{
                 result = validator.validateBird(userInput,actionsType);
                view.showMessage(String.format("%b Bird checked succesfully: ", result));
            }
        }catch (RuntimeException ex){
            view.showMessage(ex.getMessage());
        }

    }
}

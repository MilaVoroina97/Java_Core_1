package seminar.three.lection.taskTwo.NewController;

import seminar.three.lection.taskTwo.NewController.Validator;
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
        double userLengthInput = view.getUserInput();
        try{
            boolean result = validator.validate(userLengthInput,animalType,actionsType);
            view.showMessage(String.format("%b Result of check: ", result));
        }catch(RuntimeException e){
            view.showMessage(e.getMessage());
        }

    }
}

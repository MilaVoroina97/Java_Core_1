package seminar.three.lection.taskTwo.Viewer;

import seminar.three.lection.taskTwo.Exceptions.UncorrectAcceptDataRange;
import seminar.three.lection.taskTwo.Model.ActionsType;
import seminar.three.lection.taskTwo.Model.AnimalType;
import seminar.three.lection.taskTwo.NewController.AnimalController;

import java.util.Scanner;

public class Menu {

    private AnimalController animalController;
    public Menu(){
        this.animalController = new AnimalController();
    }

    public void start(){
        System.out.print("\033[H\033[J");
        try(Scanner in = new Scanner(System.in)){
            boolean flag = true;
            while (flag){
                System.out.println("Choose type of animal, which you want to check: ");
                AnimalType animalType = chooseTypeMenu(in);
                ActionsType actionsType = chooseActionMenu(in);
                System.out.println("Choose type of action, which you want to check: ");
                if (animalType != null && actionsType != null) {

                    try{
                        animalController.validateAnimal(animalType,actionsType);
                        System.out.println("Checked");
                    }catch (UncorrectAcceptDataRange e){
                        System.out.println(e.getMessage());
                    }
                }else{
                    flag = false;
                }
            }
        }
    }

    private AnimalType chooseTypeMenu(Scanner in){

        System.out.println("Which animal you want to check:\n1 - Cat\n2 - Dog\n3 - Bird\n0 - Exit");
        while (true) {
            String input = in.next();
            switch (input) {
                case "1":
                    return AnimalType.Cat;
                case "2":
                    return AnimalType.Dog;
                case "3":
                    return AnimalType.Bird;
                case "0":
                    return null;
                default:
                    System.out.println("There is not such element");
                    break;
            }
        }
    }
    private ActionsType chooseActionMenu(Scanner in){

        System.out.println("Which action you want to check:\n1 - Run\n2 - Jump\n3 - Swim\n0 - Exit");
        while (true) {
            String input = in.next();
            switch (input) {
                case "1":
                    return ActionsType.Run;
                case "2":
                    return ActionsType.Jump;
                case "3":
                    return ActionsType.Swim;
                case "0":
                    return null;
                default:
                    System.out.println("There is not such element");
                    break;
            }
        }
    }
}

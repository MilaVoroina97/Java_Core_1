package seminar.three.lection.taskTwo.Viewer;

import seminar.three.lection.taskTwo.Model.*;
import seminar.three.lection.taskTwo.NewController.AnimalController;

import java.util.Scanner;

public class Menu {

    private final Scanner in;
    private final AnimalController animalController;

    public Menu() {
        this.animalController = new AnimalController();
        in = new Scanner(System.in);

    }

    public void start() {
        System.out.print("\033[H\033[J");

        while (true) {
            Animal animal = chooseTypeMenu();
            ActionsType actionsType = chooseActionMenu();

            if (animal == null || actionsType == null) {
                break;
            }

            try {
                animalController.validateAnimal(animal, actionsType);
                System.out.println("Checked");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }


    private Animal chooseTypeMenu() {
        System.out.println("Choose type of animal, which you want to check: ");
        System.out.println("Which animal you want to check:\n1 - Cat\n2 - Dog\n3 - Bird\n0 - Exit");
        while (true) {
            int input = getNum();
            if (input == 0) {
                break;
            }
            if (input > 0 && input <= 3) {
                return switch (input) {
                    case 1 -> new Cat();
                    case 2 -> new Dog();
                    case 3 -> new Bird();
                    default -> null;
                };
            }
        }
        return null;
    }
    private ActionsType chooseActionMenu(){

        System.out.println("Choose type of action, which you want to check: ");
        System.out.println("Which action you want to check:\n1 - Run\n2 - Jump\n3 - Swim\n0 - Exit");
        while (true) {
            int input = getNum();
            if (input == 0) {
                break;
            }
            if (input > 0 && input <= ActionsType.values().length) {
                return ActionsType.getActionType(input);
            }
            System.out.println("There is not such element");
        }
        return null;
    }
    private int getNum() {
        while (true) {
            try {
                return in.nextInt();
            } catch (Exception e) {
                System.out.println("It's not a integer");
                in.next();
            }
        }
    }
}

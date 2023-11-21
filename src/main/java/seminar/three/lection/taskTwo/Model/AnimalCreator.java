package seminar.three.lection.taskTwo.Model;

import seminar.three.lection.taskTwo.Interfaces.Creator;

public class AnimalCreator implements Creator {
    @Override
    public Animal createAnimal(AnimalType type) {
        switch (type) {
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Bird:
                return new Bird();
            default:
                System.out.println("Такого животного здесь нет.");
                break;
        }
        return null;
    }
}

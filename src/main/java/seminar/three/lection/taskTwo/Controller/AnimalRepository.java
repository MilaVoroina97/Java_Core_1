package seminar.three.lection.taskTwo.Controller;

import seminar.three.lection.taskTwo.Interfaces.Creator;
import seminar.three.lection.taskTwo.Interfaces.RepositoryInterface;
import seminar.three.lection.taskTwo.Model.Animal;
import seminar.three.lection.taskTwo.Model.AnimalCreator;
import seminar.three.lection.taskTwo.Model.AnimalType;

public class AnimalRepository implements RepositoryInterface<Animal> {

    private Creator animalCreator;

    public AnimalRepository(){

        this.animalCreator = new AnimalCreator();
    }


    @Override
    public boolean create(AnimalType type) {
        Animal animal = animalCreator.createAnimal(type);
        return true;
    }
}

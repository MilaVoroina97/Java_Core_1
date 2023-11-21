package seminar.three.lection.taskTwo.Interfaces;

import seminar.three.lection.taskTwo.Model.Animal;
import seminar.three.lection.taskTwo.Model.AnimalType;

public interface Creator {

    public Animal createAnimal(AnimalType type);
}

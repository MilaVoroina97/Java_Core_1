package seminar.three.lection.taskTwo.Interfaces;

import seminar.three.lection.taskTwo.Model.AnimalType;

public interface RepositoryInterface<T> {

    public boolean create(AnimalType type);

}

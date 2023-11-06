package homework.four.task2;

public enum Gender {

    MALE("Мужской"),
    FEMALE("Женский");


    private final String label;

    /**
     * Конструктор перечисления Gender.
     *
     * @param label Метка пола.
     */
    Gender(String label) {
        this.label = label;
    }

    /**
     * Получить метку пола.
     *
     * @return Метка пола.
     */
    public String getLabel() {
        return label;
    }
}

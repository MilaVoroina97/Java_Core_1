package homework.four.task2;

public enum Category {

    STANDARD("Стандарт"),
    PREMIUM("Премиум");

    private final String label;

    /**
     * Конструктор перечисления Category.
     *
     * @param label Метка категории.
     */
    Category(String label) {
        this.label = label;
    }

    /**
     * Получить метку категории.
     *
     * @return Метка категории.
     */
    public String getLabel() {
        return label;
    }
}

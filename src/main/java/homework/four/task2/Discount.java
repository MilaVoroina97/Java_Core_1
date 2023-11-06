package homework.four.task2;

public enum Discount {

    ZERO(0),
    FIVE(5),
    TEN(10),
    FIFTEEN(15),
    TWENTY(20);

    private final int value;

    /**
     * Конструктор перечисления DiscountSize.
     *
     * @param value Процент скидки.
     */
    Discount(int value) {
        this.value =  value;
    }

    public int getValue() {
        return value;
    }
}

package homework.four.task2;

import java.util.Random;

public class Main {

    private static Customer[] customers = new Customer[2];
    private static Product[] products = new Product[5];

    public static void main(String[] args) {


        customers[0] = new Customer("Иванов", "Иван", 56, "1234567890", Gender.MALE);
        customers[1] = new Customer("Петрова", "Мария", 25, "0987654321", Gender.FEMALE);


        products[0] = new Product("Куртка", 5000.0, Category.STANDARD);
        products[1] = new Product("Индейка", 600.0, Category.PREMIUM);
        products[2] = new Product("Помидоры", 150.0, Category.STANDARD);
        products[3] = new Product("Шампунь", 500.0, Category.PREMIUM);
        products[4] = new Product("Пиво", 60.0, Category.STANDARD);

        System.out.println();

        // Устанавливаем случайную скидку на товар
        products[3].setRandomDiscount();
        System.out.println("На " + products[3].getName() + " действует скидка, раньше он стоит 400 руб. за штуку");
        System.out.println();


        // Создаем массив заказов
        Random random = new Random();
        int orderCount = random.nextInt(10) + 1;
        Order[] orders = new Order[orderCount];

        for (int i = 0; i < orders.length; i++) {
            Customer Customer = customers[random.nextInt(customers.length)];
            Product Product = products[random.nextInt(products.length)];



            int Quantity = random.nextInt(5) - 1;

            // Вызываем метод совершения покупки для заполнения массива заказов
            try {
                orders[i] = makePurchase(Customer.getLastName(), Product.getName(), Quantity);
                System.out.println("Заказ: " + orders[i].getProduct().getName() + ", количество: "
                        + orders[i].getQuantity() + ", стоимость: " + orders[i].getCost());
            } catch (CustomerException e) {
                System.out.println(e.getMessage() + " (" + Customer.getLastName() + ")");
            } catch (ProductException e) {
                System.out.println(e.getMessage() + " (" + Product.getName() + ")");
            } catch (AmountException e) {
                System.out.println(e.getMessage() + " (" + Quantity + ")");
            }
        }


        /**
         * Метод для подсчета общего количества сделанных покупок.
         *
         * @param orders массив заказов
         * @return общее количество покупок
         */
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                count++;
            }
        }

        System.out.println("Количество сделанных покупок: " + count);
    }

    /**
     * Метод для совершения покупки
     *
     * @param lastName    фамилия покупателя
     * @param productName название товара
     * @param quantity    количество товара
     * @return объект заказа
     * @throws CustomerException если передан несуществующий покупатель
     * @throws ProductException  если передан несуществующий товар
     * @throws AmountException   если передано неверное количество товара
     */
    public static <customer> Order makePurchase(String lastName, String productName, int quantity)
            throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getLastName().equals(lastName)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            throw new CustomerException("Несуществующий покупатель: " + lastName);
        }

        Product product = null;
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                product = p;
                break;
            }
        }

        if (product == null) {
            throw new ProductException("Несуществующий товар: " + productName);
        }

        if (quantity <= 0 || quantity > 99) {
            throw new AmountException("Неверное количество: " +  " " + lastName + " " + productName);
        }

        return new Order(customer, product, quantity);
    }
}

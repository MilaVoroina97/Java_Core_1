package seminar.two.seminarTask;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Задание - необходимо реализовать банкомат:
 * 1. В банкоманте находятся определенные купюры: 50, 100, 500, 1000, 5000
 * 2. В банкомат приходит запрос на выдачу определенной суммы
 * 3. Банкомат должен выдать эту сумму (если это возможно), найти возможность разделить по этим купюрам, проверить можно ли
 * из текущих купюр собрать необходимую сумму.
 * 4. Количество купюр определенных номиналов в банкомате ограниченно (50 - 3 штуки, 100 - 10 штук и т.д.)
 * 5*. Дополнительно: реализовать метод размена купюр и сделать так, что в банкомате отслеживалось количество купюр,
 * определенного номинала, и сумма выдавалась не вся сразу купюрами круного номинала сразу, а дробно (10 000 руб - не 2 - умя
 * 5000 купюрами, а ,например, одной 5000, двумя 1000, и 6 - ю 500 купюрами
 */

public class ATM {

    // Храним банкноты в словаре: где первое значение - это номинал купюры, а второе - ее количество в банкомате
    private final Map<Integer,Integer> banknotes;

    public ATM() {
        this.banknotes = new TreeMap<>(Comparator.reverseOrder());
        banknotes.put(50, 10);
        banknotes.put(100, 6);
        banknotes.put(500, 15);
        banknotes.put(1000, 9);
        banknotes.put(5000, 4);
    }

    public Map<Integer,Integer> withdraw(int amount){

        final int START_AMOUNT = amount;
        //создаем структуру данных, в которой будем хранить купюры и их количество для выдачи
        Map<Integer,Integer> toWithdraw = new TreeMap<>(Comparator.reverseOrder());
        // перебираем все купюры, которые есть в банкомате
        for(int banknote : banknotes.keySet()){
            // рассчитываем кол-во нужных банкнот каждого номинала для выдачи
            int neededBanknotes = Math.min(amount / banknote, banknotes.get(banknote));
            // при каждом проходе отнимаем из необходимой суммы текущую банкноту и ее количества
            amount -= neededBanknotes * banknote;
            // из самого банкомата каждый раз отнимаем количество купюр, которое необходимо выдать
            banknotes.put(banknote,banknotes.get(banknote) - neededBanknotes);
            // и помещаем в TreeMap купюру и ее количество для выдачи
            toWithdraw.put(banknote,neededBanknotes);
        }
        //после прохода по всем купюрам, которые есть в банкомате, если сумма будет равно 0, это будет означать, что
        // в банкомате есть все купюры, чтобы выдать необходимую сумму
        // в противном случае, в банкомате закончились необходимые купюры и мы выбрасываем исключение
        if(amount == 0) printWithdrawal(toWithdraw);
        else{
            for(int banknote : toWithdraw.keySet()){
                // если не получилось выдать нужную сумму, то нужно вернуть все купюры обратно на место
                banknotes.put(banknote,banknotes.get(banknote) + toWithdraw.get(banknote));
            }
            throw new NoBanknotesToWithdrawException(START_AMOUNT);
        }
        return toWithdraw;
    }

    private void printWithdrawal(Map<Integer,Integer> toWithdraw){
        System.out.println("Выдача:");
        for(int banknote : toWithdraw.keySet()){
            // данное условие необходимо, чтобы не распечатывать купюры, которых не надо выдавать
            if(toWithdraw.get(banknote) > 0){
                System.out.println("Купюра номиналом " + banknote + ": " + toWithdraw.get(banknote) + " шт.");
            }
        }
    }

    public static void main(String[] args) {
        new ATM().withdraw(3000);
    }
}

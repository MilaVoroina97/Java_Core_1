package seminar.five.stepik;

import java.util.function.Function;
import java.util.function.Supplier;

public class Monad<T> {

    final T value; //класс - контейнер, который содержит в себе какое - то значение

    private Monad(T value) {
        this.value = value;
    }

    /**
     * Функция, которая позволяет взять какое - либо значение и обернуть его в монаду
     *
     * @return метод возвращает новую монаду с обернутым значением
     */

    public static <T> Monad<T> from(T value) {
        return new Monad<>(value);
    }

    /**
     * @param mapFunc - производит действия со значением поля value,
     *                и после окончания действий результат может вернуть другой тип U
     * @return метод возвращает новую монаду, которая завернута в новое значение, полученное в результате
     * применения функции apply (Monad возвращает тип, полученный в результате применения функции apply)
     */

    public <U> Monad<U> flatMap(Function<T, Monad<U>> mapFunc) {
        return mapFunc.apply(value);
    }

    /**
     * этом метод оборачивает значение в новую монаду
     *
     * @return метод возвращает новую монаду со значением внутри этой монады
     */

    public <U> Monad<U> map(Function<T, U> mapFunc) {
        return flatMap(val -> new Monad<>(mapFunc.apply(val)));
    }


    public static class Optional<T> {

        private static Optional<?> empty = new Optional<>(null); //обозначение пустого Optional
        final T value;


        public Optional(T value) {
            this.value = value;
        }

        public static <T> Optional<T> from(T value) {

            if (value != null)
                return new Optional<>(value);
            else
                return (Optional<T>) empty;

        }

        public <U> Optional<U> map(Function<T,U> mapFunc){
            if(value != null)
                return flatMap(value -> new Optional<>(mapFunc.apply(value)));
            else
                return (Optional<U>) empty;
        }

        public <U> Optional<U> flatMap(Function<T,Optional<U>> mapFunc){

            return mapFunc.apply(value);
        }

    }

    public static class Lazy<T>{
         T value;

        Supplier<T> supplier; //ссылка на предыдущую монаду, через нее монады будут объединятся в цепочку

        private Lazy(T value){
            this.value = value;
        }

        public Lazy(Supplier<T> supplier) {
            this.supplier = supplier;
        }

        public static <T> Lazy<T> from(T value){

            return new Lazy<>(value);
        }

        /**
         * Функция, которая получает значение из цепочки монад
         */

        public T get(){

            if(value == null)
                value = supplier.get(); // если значение пустое - вычисляем его из предыдущей монады в цепочке
            return value;
        }

        public <U> Lazy<U> flatMap(Function<T,Lazy<U>> mapFunc){
            return mapFunc.apply(value);
        }


        /**
         * @return возвращается новый Lazy, но не со значением, полученным из функции mapFunc,
         * a в Lazy передается Supplier,с помощью которого можно получить значение в нужный момент
         * У предыдущей монады получаем значение
         */

        public <U> Lazy<U> map(Function<T,U> mapFunc){
            return new Lazy<>(() -> mapFunc.apply(get()));
        }
    }

}

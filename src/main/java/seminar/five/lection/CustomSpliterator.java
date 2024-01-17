package seminar.five.lection;

import lombok.AllArgsConstructor;

import java.io.InputStream;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class CustomSpliterator implements Spliterator<Integer> {

    private final List<Integer> numbers;
    private int start;
    private int end;


    /**
     * Method to iterate over the elements until the start position equals to or less than the end position
     *  tryAdvance is used to traverse Spliterator elements.
     * @return if the start position of the Spliterator is less than or equal to the end position,
     * the tryAdvance returns true, indicating that there are more elements to the traverse.
     */

    @Override
    public boolean tryAdvance(Consumer<? super Integer> action) {

        if(start <= end){
            action.accept(start++);
            return true;
        }
        return false;
    }

    /**
     * we want to get chunks of list elements with a size of 1000 to process them in parallel.
     * As we already figured, the size is defined by end position minus start position plus one.
     * It means that if the current Spliterator covers 1000 or less elements, there is no need to split it
     */

    @Override
    public Spliterator<Integer> trySplit() {

        if(estimateSize() <= 1000){
            return null;
        }

        int middle = (start + end) >>> 1;
        int oldStart = start;
        start = middle + 1;

        return new CustomSpliterator(numbers,oldStart,middle);
    }

    /**
     *If there are 10 000 elements, and our Spliterator start iteration at position 0 and end the iteration
     *at position 9999, we can suggest that the estimated size is 9999 - 0 + 1= 10 000:
     */
    @Override
    public long estimateSize() {
        return end - start + 1;
    }

    @Override
    public int characteristics() {
        return ORDERED | SUBSIZED | SIZED;
    }

    public static void main(String[] args) {
        List<Integer> values = IntStream.range(0, 2000)
                .boxed()
                .toList();
        Spliterator<Integer> spliterator = new CustomSpliterator(values,0,values.size() - 1);

        Integer sum = StreamSupport.stream(spliterator,true)
                .reduce(0, Integer::sum, Integer::sum);

        System.out.println(sum);

        List<Integer> spendings = List.of(14, 22, 10, 18, 16, 15, 20);

        int total = spendings.stream()
                .reduce((partialSum, next) -> partialSum + next)
                .orElse(0);
    }
}

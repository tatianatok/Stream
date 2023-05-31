import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //"Задача №1"
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(81, 45, 3, 12, 11, 56, 40, 8, 63, 11)).stream();
        findMinMax(stream, Integer::compareTo, (x, y) ->
                System.out.println("Минимальное число: " + x + ". Максимальное число: " + y));
        System.out.println();


        //"Задача №2"
        Stream<Integer> integerStream = Stream.iterate(1, i -> ++i);
        integerStream
                .filter(i -> i % 2 == 0)
                .limit(10)
                .forEach(System.out::println);

        System.out.println();

        List<Integer> numbers = Stream.of(81, 45, 3, 12, 11, 56, 40, 8, 63, 11)
                .filter(b -> b % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(numbers);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> items = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}




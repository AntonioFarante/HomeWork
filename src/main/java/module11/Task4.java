package module11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long a = 25214903917l;
        long c = 11l;
        long m = 2 ^ 48l;

        List<Long> res = generator(a, c, m).collect(Collectors.toList());
    }

    public static Stream<Long> generator(long a, long c, long m) {
        Stream<Long> stream = Stream.iterate(0l, x -> ((a * x) + c) % m);
        return stream
                .limit(10)
                .peek(System.out::println);

    }


}

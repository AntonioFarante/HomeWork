package module11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {

        String[] str = {"1, 2, 0", "4, 5"};
        List<String> stringList = Arrays.asList(str);

        String res = stringList.stream()
                .map(list -> List.of(list.split(", ")))
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println("res = " + res);
    }

}

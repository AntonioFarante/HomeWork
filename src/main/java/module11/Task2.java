package module11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        List<UsersForTest> usersForTests = List.of(
                new UsersForTest("Andzey", 1),
                new UsersForTest("Vasyl", 2),
                new UsersForTest("Oleg", 3),
                new UsersForTest("Petro", 4),
                new UsersForTest("Zahar", 5),
                new UsersForTest("Sergey", 6));

        System.out.println("convertToString(names) = " + convertToString(usersForTests));

    }

    public static String convertToString(List<UsersForTest> users) {
        return users.stream()
                .map(names -> names.getName().toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }
}

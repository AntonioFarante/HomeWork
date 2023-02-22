package module11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<UsersForTest> usersForTests = List.of(
                new UsersForTest("Andzey", 1),
                new UsersForTest("Vasyl", 2),
                new UsersForTest("Oleg", 3),
                new UsersForTest("Petro", 4),
                new UsersForTest("Zahar", 5),
                new UsersForTest("Sergey", 6));

        System.out.println("convertToOddNames(usersForTests) = " + convertToOddNames(usersForTests));
    }
    public static String convertToOddNames (List<UsersForTest> users) {
        return users.stream()
                .filter(usersForTests -> usersForTests.getId() % 2 != 0)
                .map(usersForTests -> usersForTests.getName())
                .collect(Collectors.joining(", "));

    }
}

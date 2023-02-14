package module10;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File myFile = new File("src/module10/Telefone.txt");

        if (myFile.exists()) {
            try (InputStream fis = new FileInputStream(myFile);
                 Scanner scanner = new Scanner(fis)) {

                while (scanner.hasNext()) {
                    String result = scanner.nextLine();
                    if (result.matches("\\d{3}[-]\\d{3}[-]\\d{4}") ||
                            result.matches("[(]\\d{3}[)]\\s\\d{3}[-]\\d{4}")) {
                        System.out.println(result);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package module10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Map<String, Integer> result = new HashMap<>();
        File myFile = new File("newFile.txt");

        if (myFile.exists()) {
            try (InputStream fis = new FileInputStream(myFile);
                 Scanner scanner = new Scanner(fis)) {

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] splitLine = line.split(" ");

                    for (int i = 0; i < splitLine.length; i++) {
                        if (result.containsKey(splitLine[i])) {
                            int currCounter = result.get(splitLine[i]);
                            result.put(splitLine[i], currCounter + 1);
                        } else {
                            result.put(splitLine[i], 1);
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result = " + result);
    }
}

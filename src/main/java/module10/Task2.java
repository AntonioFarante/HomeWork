package module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
            File file = new File("newFile.txt");
            InputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);

            List<User> userList = new ArrayList<>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");
                userList.add(new User(strings[0], Integer.parseInt(strings[1])));
            }
        System.out.println("userList.get(0).getName() = " + userList.get(0).getName());


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String s = gson.toJson(userList);
            System.out.println(s);

            FileWriter fileWriter= new FileWriter("user.json");
            gson.toJson(userList, fileWriter);
            fileWriter.close();
        }
}

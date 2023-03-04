package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    private static final String URI = "https://jsonplaceholder.typicode.com/users/1/todos";

    public static List<CLassForTask3> getOpenTasks(String uri, boolean isCompleted) throws IOException, InterruptedException, URISyntaxException {
        Gson GSON = new Gson();
        List<CLassForTask3> resultList = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder(new URI(URI))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        resultList = GSON.fromJson(response.body(), new TypeToken<List<CLassForTask3>>() {
        }.getType());

        System.out.println("resultList.get(1).isCompleted() = " + resultList.get(1).isCompleted());

        return resultList.stream()
                .filter(user -> user.isCompleted() == isCompleted)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("getOpenTasks(URI, false) = " + getOpenTasks(URI, false));
    }
}

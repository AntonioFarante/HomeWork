package module13;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



public class Task2 {
    public static final String URI = "https://jsonplaceholder.typicode.com/users/1/posts";

    public static void fileWriter (String url) throws IOException, InterruptedException, URISyntaxException {
        Gson GSON = new Gson();
        List<UserPost> UserPosts;

        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .GET()
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());

        UserPosts = GSON.fromJson(send.body(), new TypeToken<List<UserPost>>() {
        }.getType());

        UserPost postResult = UserPosts.stream()
                .max(Comparator.comparingInt(o -> o.id)).get();

        HttpRequest request2 = HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/posts/"
                        + postResult.id +"/comments"))
                .GET()
                .build();
        HttpResponse<String> send2 = client.send(request2, HttpResponse.BodyHandlers.ofString());

//        System.out.println("send2.body() = " + send2.body());

        FileWriter fileWriter= new FileWriter(String.format("user-%s-post-%s-comments.json", postResult.userId, postResult.id));
        GSON.toJson(send2.body(), fileWriter);
        fileWriter.close();

    }
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
       fileWriter(URI);
    }
}

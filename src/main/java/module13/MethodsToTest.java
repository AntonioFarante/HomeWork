package module13;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class MethodsToTest {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public static void sendGET(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.body() = " + response.body());
        System.out.println("response.statusCode() = " + response.statusCode());
//        User UserToJson = GSON.fromJson(response.body(), User.class);
//        return UserToJson;
    }
    public static List<User> getUserById (String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.body() = " + response.body());
        System.out.println("response.statusCode() = " + response.statusCode());
        List<User> findedUsers = GSON.fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
        return findedUsers;
    }

    public static List<User> getUserByUserName (String uri, String username) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.body() = " + response.body());
        System.out.println("response.statusCode() = " + response.statusCode());
        List<User> findedUsers = GSON.fromJson(response.body(), new TypeToken<List<User>>() {}.getType());
        return findedUsers;
    }

    public static User sendPOST(String uri, User user) throws URISyntaxException, IOException, InterruptedException {
        final String requestBody = GSON.toJson(user);
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("response.body() = " + response.body());
        System.out.println("response.statusCode() = " + response.statusCode());
        User addedUser = GSON.fromJson(response.body(), User.class);
        return addedUser;
    }

    public static List<User> MakeGetOfList(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        List<User> users = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
        return users;
    }
    public static void sendDELETE(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri + "/" + "1"))
                .DELETE()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("DELETE response.body() = " + response.body());
        System.out.println("DELETE response.statusCode() = " + response.statusCode());
    }
    public static User sendPUT (String uri, User user) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .header("Content-type", "application/json; charset=UTF-8")
                .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println("PUT response.body() = " + response.body());
        System.out.println("PUT response.statusCode() = " + response.statusCode());
        User putUser = GSON.fromJson(response.body(), User.class);
        return putUser;
    }
}

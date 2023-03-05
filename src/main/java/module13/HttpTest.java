package module13;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HttpTest {
    private static final String URI = "https://jsonplaceholder.typicode.com/users/";
    private static final String URI_ID = "https://jsonplaceholder.typicode.com/users/";
    private static final String URI_DELETE_USER = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_PUT_USER = "https://jsonplaceholder.typicode.com/users/";
    private static final String URI_GET_BY_USERNAME = "https://jsonplaceholder.typicode.com/users?username={username}";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        User user = getUser();

        List<User> userById1 = new MethodsToTest().getUserById(String.format("%s?id=%d", URI_ID, 2));

    }

    private static User getUser() {
        User user = new User();
        return user;
    }
}

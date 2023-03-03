package module13;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class HttpTest {
    private static final String URI = "https://jsonplaceholder.typicode.com/users/";
    private static final String URI_ID = "https://jsonplaceholder.typicode.com/users/2";
    private static final String URI_DELETE_USER = "https://jsonplaceholder.typicode.com/users";
    private static final String URI_PUT_USER = "https://jsonplaceholder.typicode.com/users/";
    private static final String URI_GET_BY_USERNAME = "https://jsonplaceholder.typicode.com/users?username={username}";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        User user = getUser();

      //  MethodsToTest.sendGET(URI);

       MethodsToTest.sendPOST(URI, user);
//
//        MethodsToTest.sendDELETE(URI_DELETE_USER);
//
//        MethodsToTest.sendPUT(URI_PUT_USER, getUser());

 //       String format = String.format("%s?id=%d", URI_ID, 2);
        String userName = "Samantha";
        String uri = String.format("%s?username=%s","https://jsonplaceholder.typicode.com/users", userName);
        MethodsToTest.getUserByUserName(uri, userName);

    }

    private static User getUser() {
        User user = new User();
        return user;
    }
}

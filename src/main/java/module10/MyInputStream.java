package module10;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;

public class MyInputStream extends InputStream {

    Queue<Byte> test = new ArrayDeque<>();

    public MyInputStream(String stringSource) {
        byte[] bytes = stringSource.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            test.add(aByte);
        }

    }

    @Override
    public int read() throws IOException {
        if(available() > 0) {
            return test.poll();
        }
        return -1;
    }

    @Override
    public int available() throws IOException {
        return test.size();
    }
}

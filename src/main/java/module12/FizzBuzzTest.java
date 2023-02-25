package module12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        FizzBuzz fizzBuzzService = new FizzBuzz();
        service.submit(fizzBuzzService::fizz);
        service.submit(fizzBuzzService::buzz);
        service.submit(fizzBuzzService::fizzBuzz);
        service.submit(fizzBuzzService::number);
        service.submit(fizzBuzzService::printResult);
        service.shutdown();
    }
}

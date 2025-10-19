import java.util.concurrent.*;

public class MultiThreadDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return (int) (Math.random() * 100);
        };

        Future<Integer> result = service.submit(task);
        System.out.println("Random Number: " + result.get());
        service.shutdown();
    }
}

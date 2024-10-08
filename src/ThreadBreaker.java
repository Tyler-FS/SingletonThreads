import java.util.ArrayList;
import java.util.List;

public class ThreadBreaker implements Runnable{
    private String threadName;

    public ThreadBreaker(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        LazyInitializedSingleton instance =
                LazyInitializedSingleton.getInstance();
        ThreadSafeSingleton instance2 =
                ThreadSafeSingleton.getInstance();
        System.out.println(this.getThreadName() + " has LazyInitializedSingleton instance " + instance.hashCode() + " and ThreadSafeSingleton instance " + instance2.hashCode());
    }

    public String getThreadName() {
        return threadName;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            threads.add(new Thread(new ThreadBreaker("Thread" + i)));
        }
        for( Thread t : threads ) {
            t.start();
        }
    }
}

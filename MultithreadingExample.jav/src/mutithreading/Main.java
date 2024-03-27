package mutithreading;

public class Main {
    public static void main(String[] args) {
        Counter sharedCounter = new Counter();
        MultiThread thread1 = new MultiThread(sharedCounter);
        MultiThread thread2 = new MultiThread(sharedCounter);
        thread1.start();
        thread2.start();
    }

}
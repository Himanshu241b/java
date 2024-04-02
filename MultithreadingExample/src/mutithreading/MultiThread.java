package mutithreading;

public class MultiThread extends Thread{
    Counter counter;
    MultiThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
    counter.increment();
    }
}

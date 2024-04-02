package mutithreading;

public class Counter{
    int counter;
    public void increment(){
        for(int i = 0; i < 5; i++){
            ++counter;
            System.out.println(counter);
        }
    }
}

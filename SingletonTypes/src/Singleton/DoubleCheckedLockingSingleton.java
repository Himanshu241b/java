package Singleton;


//optimization to lazy initialization where synchronization is only applied when the instance is not yet created.
//Tradeoff:
//
//Pros: Better performance compared to simple lazy initialization due to reduced synchronization overhead.
//Cons: Requires proper implementation to ensure correctness, which can be error-prone.
public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton(){}

    public static DoubleCheckedLockingSingleton getInstance(){
        if(instance == null){
            synchronized(DoubleCheckedLockingSingleton.class){
                if(instance == null){
                    return new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}

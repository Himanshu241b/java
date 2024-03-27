package Singleton;

//the instance of the Singleton class is created only when it's requested for the first time.
//Tradeoff:
//
//Pros: Lazy initialization conserves resources by creating the instance only when needed.
//        Cons: Requires explicit synchronization to maintain thread safety, which can impact performance.
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if(instance == null){
            return new LazySingleton();
        }
        return instance;
    }

}

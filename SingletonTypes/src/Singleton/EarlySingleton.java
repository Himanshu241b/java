package Singleton;

//the instance of the Singleton class is created when the class is loaded.
//Tradeoff:
//
//Pros: Simple to implement and thread-safe by default.
//Cons: The instance is created even if it's not needed, potentially wasting resources if the Singleton is resource-intensive.
public class EarlySingleton {
    private static final EarlySingleton instance = new EarlySingleton();

    private EarlySingleton() {}

    public static EarlySingleton getInstance() {
        return instance;
    }

}

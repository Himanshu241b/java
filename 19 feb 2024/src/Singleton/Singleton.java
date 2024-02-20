package Singleton;

class Singleton {
    // a static private variable to refer to object of this class
    static private Singleton  singletonInstance = null;

    //private constructor so this class cant be instantiated from outside 
    private Singleton() {
        // constructor code
    }

    //private static method to get instance of this class 
    public static Singleton getInstance() {
        synchronized(Singleton.class) { /* Block level synchronization(synchronizes the critical section to ensure thread safety)*/
        if(singletonInstance == null)
            return singletonInstance = new Singleton();
        }
            return singletonInstance;
        
    }
}
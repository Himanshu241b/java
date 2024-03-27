package Singleton;

public class InitializationOnDemandSingleton {
    private InitializationOnDemandSingleton(){}

    private static class SingletonHolder{
        private static final InitializationOnDemandSingleton instance = new InitializationOnDemandSingleton();
    }

    public static InitializationOnDemandSingleton getInstance(){
        return SingletonHolder.instance;
    }
}

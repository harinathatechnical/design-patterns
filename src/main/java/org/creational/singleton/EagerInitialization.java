package src.main.java.org.creational.singleton;

public class EagerInitialization {

    private static final EagerInitialization instance = new
            EagerInitialization();
//private constructor to avoid client applications to use constructor
    private EagerInitialization(){}
    public static EagerInitialization getInstance(){
        return instance;
    }
}

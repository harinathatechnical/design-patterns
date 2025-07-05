package src.main.java.org.creational.singleton;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Eager
        EagerInitialization eagerInitialization = EagerInitialization.getInstance();
        EagerInitialization eagerInitialization1 = EagerInitialization.getInstance();
        System.out.println(eagerInitialization == eagerInitialization1);

        // static block

        StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
        StaticBlockSingleton singleton1 = StaticBlockSingleton.getInstance();

        System.out.println(singleton1 == singleton);

        // LazyInitializedSingleton

        LazyInitializedSingleton lazyInitializedSingleton = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton lazyInitializedSingleton1 = LazyInitializedSingleton.getInstance();

        System.out.println(lazyInitializedSingleton1 == lazyInitializedSingleton);

        // ThreadSafeSingleton

        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
        ThreadSafeSingleton threadSafeSingleton1 = ThreadSafeSingleton.getInstanceUsingDoubleLocking();

        System.out.println(threadSafeSingleton1 == threadSafeSingleton);

        // BillPughSingleton

        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        BillPughSingleton billPughSingleton1 = BillPughSingleton.getInstance();

        System.out.println(billPughSingleton1 == billPughSingleton);


        // break singleton using reflection

        EagerInitialization instanceOne =
                EagerInitialization.getInstance();
        EagerInitialization instanceTwo = null;
        try {
            Constructor[] constructors =
                    EagerInitialization.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
//Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (EagerInitialization)
                        constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());


        // enum
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;

        System.out.println(enumSingleton1 == enumSingleton);


        // serialization

        SerializedSingleton instanceOneSer =
                SerializedSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
        out.writeObject(instanceOneSer);
        out.close();
//deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwoSer = (SerializedSingleton)
                in.readObject();
        in.close();
        System.out.println("instanceOneSer hashCode="+instanceOneSer.hashCode());
        System.out.println("instanceTwoSer hashCode="+instanceTwoSer.hashCode());
    }


}
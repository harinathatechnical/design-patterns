package src.main.java.org.creational.abstractfactory;

public class ComputerFactory {
    public static Computer getComputer(ComputerAbstractFactory factory) {
        return factory.createComputer();
    }
}
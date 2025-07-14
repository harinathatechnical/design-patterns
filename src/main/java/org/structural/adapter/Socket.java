package src.main.java.org.structural.adapter;

public class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}
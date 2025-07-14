---

## 🔌 Adapter Design Pattern

The **Adapter Design Pattern** is one of the **Structural Design Patterns**.  
It is used when you want **two unrelated interfaces to work together**.

The **object that joins these unrelated interfaces** is called an **Adapter**.

---

### 📌 Real-Life Example

A good real-world example of an Adapter is a **mobile charger**:

- A mobile battery typically needs **3 volts** to charge.
- But the standard wall socket provides either **120V (US)** or **240V (India)**.
- The **mobile charger acts as an Adapter** between the wall socket and your phone — converting high voltage to the level required by the battery.

---

### ⚙️ What We’ll Implement

In this tutorial, we’ll implement a **multi-adapter** using the **Adapter Design Pattern**.

This will help you understand how to:
- Make **incompatible interfaces work together**.
- **Wrap** existing classes with an Adapter to provide new functionality **without changing original code**.

---

✅ **Next:**  
Check out the example code to see how the Adapter connects two different interfaces!

---

    public class Volt {
        private int volts;

        public Volt(int v) {
            this.volts = v;
        }
    
        public int getVolts() {
            return volts;
        }
    
        public void setVolts(int volts) {
            this.volts = volts;
        }
    }

    public class Socket {
        public Volt getVolt() {
            return new Volt(120);
        }
    }

    public interface SocketAdapter {
        public Volt get120Volt();
        public Volt get12Volt();
        public Volt get3Volt();
     }

---

### 🔄 Two-Way Adapter Pattern

When implementing the **Adapter Pattern**, there are **two common approaches**:  
**Class Adapter** and **Object Adapter**.

Both approaches achieve the **same goal** — making **incompatible interfaces work together** — but they do so using different mechanisms.

---

### 📌 1️⃣ Class Adapter

- ✅ Uses **Java inheritance**.
- The Adapter **extends the source class** (e.g., `Socket`).
- This means it inherits functionality from the source and adapts it to the target interface.

---

### 📌 2️⃣ Object Adapter

- ✅ Uses **Java composition**.
- The Adapter **contains an instance of the source class**.
- It **delegates calls** to the contained object to adapt the interface as needed.

---

**Key Point:**  
Both forms produce the **same result**, but the **Object Adapter** is more flexible — because Java **doesn’t support multiple inheritance**, so composition is often the practical choice in real-world applications.

---

✅ **Tip:**  
Choose **Class Adapter** if you can safely extend a single source class.  
Choose **Object Adapter** if you need to **adapt multiple classes**, or want **greater flexibility**.

---

    /Using inheritance for adapter pattern
    public class SocketClassAdapterImpl extends Socket implements
    SocketAdapter {
        @Override
        public Volt get120Volt() {
        return getVolt();
        }
    
        @Override
        public Volt get12Volt() {
            Volt v = getVolt();
            return convertVolt(v, 10);
        }
    
        @Override
        public Volt get3Volt() {
            Volt v = getVolt();
            return convertVolt(v, 40);
        }
    
        private Volt convertVolt(Volt v, int i) {
            return new Volt(v.getVolts() / i);
        }
    }

    public class SocketObjectAdapterImpl implements SocketAdapter {
    //Using Composition for adapter pattern
        private Socket sock = new Socket();
    
        @Override
        public Volt get120Volt() {
            return sock.getVolt();
        }
    
        @Override
        public Volt get12Volt() {
            Volt v = sock.getVolt();
            return convertVolt(v, 10);
        }
    
        @Override
        public Volt get3Volt() {
            Volt v = sock.getVolt();
            return convertVolt(v, 40);
        }
    
        private Volt convertVolt(Volt v, int i) {
            return new Volt(v.getVolts() / i);
        }
    }


        public class AdapterPatternTest {
        public static void main(String[] args) {
            testClassAdapter();
            testObjectAdapter();
        }
    
        private static void testObjectAdapter() {
            SocketAdapter sockAdapter = new SocketObjectAdapterImpl();
            Volt v3 = getVolt(sockAdapter, 3);
            Volt v12 = getVolt(sockAdapter, 12);
            Volt v120 = getVolt(sockAdapter, 120);
            System.out.println("v3 volts using Object Adapter = " + v3.getVolts());
            System.out.println("v12 volts using Object Adapter = " + v12.getVolts());
            System.out.println("v120 volts using Object Adapter = " + v120.getVolts());
        }
    
        private static void testClassAdapter() {
            SocketAdapter sockAdapter = new SocketClassAdapterImpl();
            Volt v3 = getVolt(sockAdapter, 3);
            Volt v12 = getVolt(sockAdapter, 12);
            Volt v120 = getVolt(sockAdapter, 120);
            System.out.println("v3 volts using Class Adapter = " + v3.getVolts());
            System.out.println("v12 volts using Class Adapter = " + v12.getVolts());
            System.out.println("v120 volts using Class Adapter = " + v120.getVolts());
        }
    
        private static Volt getVolt(SocketAdapter sockAdapter, int i) {
            switch (i) {
                case 3:
                    return sockAdapter.get3Volt();
                case 12:
                    return sockAdapter.get12Volt();
                case 120:
                    return sockAdapter.get120Volt();
                default:
                    return sockAdapter.get120Volt();
            }
        }
    }

---

### 📚 Adapter Pattern Examples in JDK

The **Adapter Pattern** is widely used in the Java Standard Library to make **incompatible interfaces work together**.

Here are some common real-world examples:

- 🔌 `java.util.Arrays#asList()`  
  Converts an **array** into a **List** — adapting array operations to the `List` interface.

- 🔌 `java.io.InputStreamReader(InputStream)`  
  Takes an `InputStream` and **adapts it to a `Reader`**, bridging byte streams and character streams.

- 🔌 `java.io.OutputStreamWriter(OutputStream)`  
  Takes an `OutputStream` and **adapts it to a `Writer`**, for converting character streams into byte streams.

---

✅ **Key Idea:**  
The Adapter Pattern makes **existing classes work with new interfaces** — **without changing their source code**.

---

**Happy Designing!** 🔌📚



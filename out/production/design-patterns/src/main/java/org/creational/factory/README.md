## Factory Design Pattern

The **Factory Pattern** is one of the **Creational Design Patterns** and is widely used in the JDK as well as frameworks like **Spring** and **Struts**.

The Factory Design Pattern is useful when we have a **superclass with multiple subclasses**, and based on input, we need to return one of the subclasses.

This pattern removes the responsibility of instantiating classes from the client code and delegates it to a **Factory class**.

---

### When to Use

- When the exact type of object to create is determined at runtime.
- When you want to provide a common interface for creating families of related objects.

---

- Super class in factory pattern can be an interface, abstract class or a normal
java class.

---

## ✅ Benefits of Factory Pattern

1. **Code to Interface**  
   The Factory Pattern promotes coding to an **interface** rather than an **implementation**.

2. **Loose Coupling**  
   It removes the instantiation logic of concrete classes from the client code, making the system **more robust**, **less coupled**, and **easier to extend**.  
   For example, you can easily change the `PC` class implementation without affecting the client code.

3. **Abstraction**  
   It provides an abstraction between the implementation and the client classes through **inheritance and interfaces**.

---

## 📌 Factory Pattern Examples in JDK

Some popular usages of the Factory Pattern in the Java Standard Library include:

- `java.util.Calendar#getInstance()`
- `java.util.ResourceBundle#getBundle()`
- `java.text.NumberFormat#getInstance()`
- `valueOf()` methods in wrapper classes like `Boolean`, `Integer`, etc.

These built-in factories hide the complex instantiation logic and provide ready-to-use objects.

---


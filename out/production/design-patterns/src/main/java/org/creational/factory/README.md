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
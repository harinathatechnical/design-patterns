---

## 🏗️ Builder Design Pattern

The **Builder Pattern** is a **Creational Design Pattern**, just like the **Factory Pattern** and **Abstract Factory Pattern**.  

It was introduced to solve problems that arise with the Factory and Abstract Factory Patterns when an object contains **many attributes**.

---

### 📌 Why Builder Pattern?

When an object has a large number of fields, using a simple Factory can lead to several issues:

1. **Too Many Arguments:**  
   You have to pass too many arguments from the client program to the factory class. This is **error-prone**, especially when multiple arguments have the same type and their **order must be maintained**.

2. **Optional Parameters:**  
   Some parameters may be optional, but the Factory Pattern typically forces you to pass all parameters. This often leads to sending `null` values for optional ones, which is **messy and unsafe**.

3. **Complex Object Construction:**  
   If an object is heavy and its creation is complex, then all that complexity ends up in the Factory classes — making them **confusing and hard to maintain**.

---

### ⚙️ Why Not Just Use Setters?

You might think about solving this by providing:
- A constructor with required parameters, and
- `setter` methods for optional ones.

But this leads to another problem: the object’s state can be **inconsistent** until all the setters are called correctly.

---

### ✅ How Builder Pattern Helps

The **Builder Pattern** solves these problems by:
- Letting you **build the object step-by-step**.
- Keeping the object **immutable** or fully consistent once built.
- Returning the **final object** only when it’s completely configured.

---

### 📖 Summary

- 🚫 Avoids constructor parameter explosion.
- 🚫 Avoids inconsistent object states.
- ✅ Supports readable, maintainable, and flexible object creation.

---

## 🛠️ Steps to Implement Builder Pattern

Here’s how you typically **create a Builder Pattern** in Java:

---

### 📌 1️⃣ Create a Static Nested Builder Class

- Define a **static nested class** inside your main class.
- Copy all the attributes from the outer class to the **Builder class**.
- ✅ **Naming convention:**  
  If your class is named `Computer`, the builder class should be named `ComputerBuilder`.

---

### 📌 2️⃣ Provide a Public Constructor for Required Fields

- The **Builder class** should have a **public constructor** with all the **required attributes** as parameters.
- This ensures that mandatory fields are always set.

---

### 📌 3️⃣ Add Methods for Optional Fields

- In the Builder class, create **methods to set optional attributes**.
- Each method should **return the same Builder object** so you can chain calls:
  ```java
  public ComputerBuilder setGraphicsCard(String graphicsCard) {
      this.graphicsCard = graphicsCard;
      return this;
  }

---

### 📌 4️⃣ Final Step: Add a `build()` Method and Private Constructor

- The **final step** is to add a `build()` method inside the Builder class.
- The `build()` method **returns the fully constructed object** that the client needs.
- To make this work, your main class should have a **private constructor** that accepts the Builder object as an argument.
- This constructor copies the values from the Builder to the final object.

✅ **This ensures that the object can only be created through the Builder**, keeping it consistent and immutable.

---

**Example:**

```java
// Inside Builder class
public Computer build() {
    return new Computer(this);
}

// Inside main class
private Computer(ComputerBuilder builder) {
    this.RAM = builder.RAM;
    this.HDD = builder.HDD;
    this.graphicsCard = builder.graphicsCard;
    this.bluetoothEnabled = builder.bluetoothEnabled;
}

```
---

## 📌 Builder Pattern Examples in JDK

The **Builder Pattern** is used in the Java Standard Library in several places.

Common examples include:

- 🧩 `java.lang.StringBuilder#append()` — *unsynchronized*
- 🧩 `java.lang.StringBuffer#append()` — *synchronized*

Both classes allow you to build a complex `String` step-by-step using chained `append()` calls — just like a typical builder!

---
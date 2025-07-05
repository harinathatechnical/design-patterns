---

## 🧬 Prototype Design Pattern

The **Prototype Pattern** is one of the **Creational Design Patterns**, which means it provides a mechanism for **object creation**.

---

### 📌 What is the Prototype Pattern?

The Prototype Pattern is useful when **creating an object is costly** — in terms of **time, system resources, or complexity** — but you already have a similar object available.

Instead of creating a new object from scratch every time, the Prototype Pattern lets you **clone** an existing object and modify it as needed.

This pattern typically relies on **Java’s cloning mechanism** to copy objects efficiently.

---

### ⚙️ When to Use

- When object creation is **expensive** (e.g., loading large data from a database).
- When you need **many similar objects** with slight modifications.
- When you want to **avoid repetitive initialization logic**.

---

### 🗂️ Example Scenario

Suppose you have an object that **loads data from a database**.  
You need to use this data in different places in your program, often with small changes.

❌ **Bad approach:**  
Using the `new` keyword to create a new object and **reload the same data** from the database every time.

✅ **Better approach:**  
Clone the existing object into a **new object** and modify the clone as needed.  
This saves **time and system resources**.

---

### ✅ Key Point

The **Prototype Pattern mandates** that **the object itself** should provide the copying feature — not any other class.

Depending on your requirements, you can choose between:
- **Shallow Copy:** Fields are copied as references.
- **Deep Copy:** Fields are cloned recursively to ensure a fully independent copy.

👉 The choice between shallow and deep copy is a **design decision**.

---

### 📌 Example in Java

```java
public class Employee implements Cloneable {
    private List<String> employeeList;

    public Employee() {
        this.employeeList = new ArrayList<>();
    }

    public Employee(List<String> list) {
        this.employeeList = list;
    }

    public void loadData() {
        // Loads data from database (mock)
        employeeList.add("John");
        employeeList.add("Jane");
        employeeList.add("Mark");
    }

    public List<String> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>(this.employeeList);
        return new Employee(temp);
    }
}

// Client code
public class PrototypePatternDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp = new Employee();
        emp.loadData();

        // Clone the object
        Employee empClone = (Employee) emp.clone();
        List<String> list = empClone.getEmployeeList();
        list.add("Emma");

        System.out.println(emp.getEmployeeList());    // Original
        System.out.println(list);                     // Clone with modification
    }
}

---

## 🌳 Composite Design Pattern

The **Composite Pattern** is a **Structural Design Pattern** that lets you treat **individual objects** and **compositions of objects** (or “composites”) **the same way**.

---

### 📌 What is the Composite Pattern?

The pattern organizes objects in a **tree structure**, where each node is either:
- an **individual part** (*leaf*)
- or a **group of parts** (*composite*) that can contain more nodes.

This allows you to **work with single objects and groups uniformly** — for example, you can call the same method on a single element or an entire hierarchy.

---

### ⚙️ Core Components

The Composite Pattern can be broken down into **four main parts**:

1️⃣ **Component**
- The **base interface** (or abstract class) for **all objects** in the composition.
- Declares **common methods** to manage child elements.

2️⃣ **Leaf**
- Implements the **default behavior** of the base component.
- Represents **end objects** of the tree structure — it **does not contain child references**.

3️⃣ **Composite**
- Contains **leaf elements** or other composites.
- Implements base component methods and **defines operations to manage children**.

4️⃣ **Client**
- Interacts with the objects in the composition **through the base component interface**.
- It **does not need to know** if it’s working with a leaf or a composite.

---

### 🌳 Key Benefit

✅ The Composite Pattern makes it easy to build **complex hierarchies** and **treat them uniformly**, which greatly simplifies client code.

---

### 📌 Example Use Cases

- File system directories and files.
- Graphics drawing editors (shapes within groups).
- UI frameworks (containers and widgets).

---

---

## 🌳 Composite Pattern — Hierarchical Departments Example

Let’s dive into the **Composite Pattern** with a practical **company departments hierarchy** example.

---

### 📌 3.1 The Base Component

First, define a simple **`Department` interface**, which acts as the **base component**:

```java
public interface Department {
    void printDepartmentName();
}

public class FinancialDepartment implements Department {

    private Integer id;
    private String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

    // standard constructor, getters, setters
}
public class SalesDepartment implements Department {

    private Integer id;
    private String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

    // standard constructor, getters, setters
}
public class HeadDepartment implements Department {
    private Integer id;
    private String name;

    private List<Department> childDepartments;

    public HeadDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.childDepartments = new ArrayList<>();
    }

    public void printDepartmentName() {
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }
}

public class CompositeDemo {
    public static void main(String args[]) {
        Department salesDepartment = new SalesDepartment(
                1, "Sales department");
        Department financialDepartment = new FinancialDepartment(
                2, "Financial department");

        HeadDepartment headDepartment = new HeadDepartment(
                3, "Head department");

        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);

        headDepartment.printDepartmentName();
    }
}
```
### 📌 Important Points About Composite Pattern

✅ **When to Use:**
- The **Composite Pattern** should be applied **only when a group of objects needs to behave like a single object**.
- It is especially useful for creating **tree-like structures** of objects with **hierarchical relationships**.

---

### 🌳 Real-World Example in Java

A great example of the Composite Pattern in the Java API is:

- **`java.awt.Container#add(Component)`** —  
  This is widely used in **Swing**, where a container (like a `JPanel`) can contain **individual components** or **nested containers**, all treated uniformly.

---

**Key takeaway:** The Composite Pattern helps manage complex object trees by providing **consistent operations** for **both leaves and groups**.

---

**Happy Designing!** 🌳✨

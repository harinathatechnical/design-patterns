---

## 🪶 Flyweight Design Pattern

The **Flyweight Design Pattern** is a **Structural Design Pattern** — like the **Facade**, **Adapter**, and **Decorator** patterns.

---

### 📌 Intent (GoF)

**Definition:**  
The Flyweight Pattern is used to **minimize memory usage** by **sharing as much data as possible** with similar objects.

---

### 🗂️ When to Use

The Flyweight Pattern is ideal when:

- ✅ Your application needs to **create a huge number of objects**.
- ✅ Creating these objects is **heavy on memory** and **time-consuming**.
- ✅ The object’s properties can be **divided** into:
    - **Intrinsic properties:** Shared and **unique for the type**.
    - **Extrinsic properties:** Supplied by **client code** and vary for each use.

---

### 🧩 How It Works

Before using the Flyweight Pattern, **analyze** the object’s data:

- **Intrinsic State:**
    - Stored **internally**.
    - **Shared** between multiple objects.
    - Does **not change** across contexts.

- **Extrinsic State:**
    - **Supplied by the client** at runtime.
    - **Context-specific**.
    - Passed into methods when performing operations.

---

### 📌 Example Use Case

The Flyweight Pattern is especially useful for **memory-constrained environments** like:
- Mobile devices
- Embedded systems
- Games (for example, large numbers of tree objects in a forest)

---

✅ **Key Benefit:**  
The Flyweight Pattern **reduces memory usage** by **sharing objects** instead of creating new ones for every use.

---
## ✅ Components of the Flyweight Pattern

- Flyweight Interface/Abstract Class: This defines the interface for concrete flyweights. Typically, it includes a method to accept and process the extrinsic state.
- Concrete Flyweight: These are the actual flyweight objects that implement the Flyweight interface. They store intrinsic states that can be shared among multiple objects.
- Flyweight Factory: This is responsible for creating and managing flyweight objects. It ensures that flyweights are shared and reused as much as possible.
- Client: The client code uses flyweights to create and manipulate objects. It passes the extrinsic state to the flyweights when needed.

# Implementing the Flyweight Pattern in Game Development
Let’s see how the Flyweight pattern can be applied in a simple game development scenario where we need to efficiently represent and manage thousands of game objects.

Step 1: Flyweight Interface

    interface GameObject {
        void render(String player);
    }
Step 2: Concrete Flyweight

        class Tree implements GameObject {
            private final String type;
            
                public Tree(String type) {
                    this.type = type;
                }
            
                @Override
                public void render(String player) {
                    System.out.println("Rendering a " + type + " for player " + player);
                }
        }
Step 3: Flyweight Factory

    class GameObjectFactory {
    private final Map<String, GameObject> gameObjects = new HashMap<>();
    
        public GameObject getGameObject(String type) {
            return gameObjects.computeIfAbsent(type, Tree::new);
        }
    }
Step 4: Client (Game)

    public class Game {

    public static void main(String[] args) {

    GameObjectFactory gameObjectFactory = new GameObjectFactory();
    
            // Simulate rendering game objects for multiple players
            String[] players = {"Player 1", "Player 2", "Player 3"};
    
            for (String player : players) {
                GameObject tree = gameObjectFactory.getGameObject("Tree");
                tree.render(player);
            }
        }
    }

In this example, we have a GameObjectFactory responsible for creating and sharing game objects. The Tree object represents a game object, and its intrinsic state (the type of tree) is shared among multiple players. By employing the Flyweight pattern, we minimize memory usage while rendering game objects for various players.

---
---

### 📚 Flyweight Pattern Example in JDK

The **Flyweight Pattern** is actually used behind the scenes in **Java’s core classes**!

✅ **Examples:**
- All **wrapper classes** (`Integer`, `Boolean`, `Character`, etc.) use the `valueOf()` method to **return cached objects** instead of creating new ones every time.
- The **Java String Pool** is the best-known example — where identical `String` literals are **interned and shared**, saving memory.

---

### 📌 Important Points to Remember

- 🔑 In a real-world implementation, the **client code is not always forced** to use a **Flyweight Factory** — but doing so ensures that objects are actually **shared** instead of duplicated.
- ⚠️ The Flyweight Pattern can **increase complexity**:
    - If the number of **shared objects** is huge, there’s a **trade-off** between **memory savings** and **time spent managing them**.
- ✅ Use this pattern **wisely** — it’s best when the **intrinsic state is minimal**, stable, and highly shareable.

---

**Key takeaway:**  
The Flyweight Pattern is powerful for **reducing memory footprint**, but only when the conditions fit — **don’t overuse it!**

---

## Conclusion

The Flyweight design pattern is a game-changer in the realm of game development. By efficiently managing and sharing common game objects, it can significantly boost the performance of your games while keeping memory overhead in check.

---

**Happy Designing!** 🪶✨

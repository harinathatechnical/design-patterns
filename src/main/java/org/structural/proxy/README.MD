---

## 🛡️ Proxy Design Pattern

The **Proxy Design Pattern** is one of the **Structural Design Patterns** and is also one of the **simplest patterns to understand**.

---

### 📌 Intent (GoF)

**Definition:**  
The Proxy Pattern provides a **surrogate or placeholder** for another object to **control access to it**.

---

### 🔑 When to Use

The Proxy Pattern is used when you want to **provide controlled access** to some functionality.

---

### 🧩 Example Scenario

Imagine you have a class that can **run system commands**.  
If you use it internally, that’s fine — but if you expose it to **client applications**, it could be dangerous:

- A client could run a command that **deletes system files**.
- Or it could **change settings** you don’t want them to modify.

✅ **Solution:**  
Use a **Proxy class** to wrap the original class and provide **controlled access**.  
The Proxy decides **which operations are allowed** and which are not.

---

**Key Benefit:**  
The Proxy Pattern helps you **restrict, protect, or add additional logic** before delegating calls to the actual object.

---
A. Main Class
Since we code Java in terms of interfaces, here is our interface and its
implementation class.
```
public interface CommandExecutor {
    public void runCommand(String cmd) throws Exception;
}


public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand(String cmd) throws IOException {
        //some heavy implementation
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }

}

```
B. Proxy Class
Now we want to provide only admin users to have full access of above class,
if the user is not admin then only limited commands will be allowed. Here is
our very simple proxy class implementation.

```
public class CommandExecutorProxy implements CommandExecutor {
    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Test".equals(user) && "Test".equals(pwd))
            isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for nonadmin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}

public class ProxyPatternTest {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("Test",
                "wrong_pwd");
        try {
            executor.runCommand("ls -ltr");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }
}

```

**Happy Designing!** 🛡️✨

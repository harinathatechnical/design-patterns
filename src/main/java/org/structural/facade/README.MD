---

## 🏢 Facade Design Pattern

The **Facade Pattern** is one of the **Structural Design Patterns** (just like **Adapter** and **Decorator**) — it’s used to help **client applications interact with complex systems easily**.

---

### 📌 Intent (GoF)

**Definition:**
> *Provide a unified interface to a set of interfaces in a subsystem. The Facade Pattern defines a higher-level interface that makes the subsystem easier to use.*

---

### 🧩 Example Scenario

Suppose you have an application that:
- Connects to **different databases** (e.g., MySQL, Oracle).
- Generates different types of **reports** (HTML, PDF, etc.).

To do this, you might have:
- Multiple **interfaces** for each **database**.
- Multiple **interfaces** for each **report format**.

---

When your system grows more complex, the **client application** must deal with:
- Many **different interfaces**.
- Complex **workflows**.
- Possibly **confusing method names**.

---

✅ **Solution:**  
Apply the **Facade Pattern**!  
Provide a **wrapper interface** on top of all these subsystems — so the **client** interacts with **just one simple interface**, which handles the underlying complexity for them.

---

**Benefits:**
- Simplifies the usage of complex subsystems.
- Provides a **single entry point**.
- Reduces **coupling** between client code and subsystem classes.

---
# A. Set of Interfaces
```
public class MySqlHelper {
    public static Connection getMySqlDBConnection() {
//get MySql DB connection using connection parameters
        return null;
    }

    public void generateMySqlPDFReport(String tableName, Connection
            con) {
//get data from table and generate pdf report
    }

    public void generateMySqlHTMLReport(String tableName, Connection
            con) {
//get data from table and generate pdf report
    }
}

public class OracleHelper {
    public static Connection getOracleDBConnection() {
//get MySql DB connection using connection parameters
        return null;
    }

    public void generateOraclePDFReport(String tableName, Connection
            con) {
//get data from table and generate pdf report
    }

    public void generateOracleHTMLReport(String tableName, Connection
            con) {
//get data from table and generate pdf report
    }
}

```
# B. Facade Interface

```
package src.main.java.org.structural.facade;

import java.sql.Connection;

public class HelperFacade {
    public static void generateReport(DBTypes dbType, ReportTypes
            reportType, String tableName) {
        Connection con = null;
        switch (dbType) {
            case MYSQL:
                con = MySqlHelper.getMySqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType) {
                    case HTML:
                        mySqlHelper.generateMySqlHTMLReport(tableName, con);
                        break;
                    case PDF:
                        mySqlHelper.generateMySqlPDFReport(tableName, con);
                        break;
                }
                break;
            case ORACLE:
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType) {
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName, con);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName, con);
                        break;
                }
                break;
        }
    }

    public static enum DBTypes {
        MYSQL, ORACLE;
    }

    public static enum ReportTypes {
        HTML, PDF;
    }
}
```
# C. Client Program

```
package src.main.java.org.structural.facade;

import java.sql.Connection;

public class FacadePatternTest {
    public static void main(String[] args) {
        String tableName = "Employee";
//generating MySql HTML report and Oracle PDF report without using Facade
        Connection con = MySqlHelper.getMySqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMySqlHTMLReport(tableName, con);
        Connection con1 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName, con1);
//generating MySql HTML report and Oracle PDF report using Facade
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL,
                HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE,
                HelperFacade.ReportTypes.PDF, tableName);
    }
}

```
---

### 📌 Important Points About Facade Pattern

✅ **Key things to remember:**

- 🔑 **Facade is like a helper:**  
  It provides a simpler interface for client applications — **it does NOT hide subsystem interfaces**. Whether to use the Facade or call subsystems directly is **up to the client**.

- 🏗️ **When to apply:**  
  The Facade Pattern can be added **at any point during development**, especially when the number of interfaces grows and the system becomes complex.

- 🔌 **Loose coupling:**  
  Subsystem classes **should not know** about the Facade — they must have **no reference** to it. The Facade depends on the subsystem, not the other way around.

- 📚 **Use it for related interfaces:**  
  A Facade works best when it **wraps similar or related interfaces**, offering **one unified API** instead of multiple similar ones.

- ⚙️ **Combine with Factory:**  
  Facade and Factory Patterns are often **used together** to offer an even **simpler, higher-level interface** to client applications.

---

✅ **Key takeaway:**  
The Facade Pattern **simplifies complex systems**, promotes **clean code**, and reduces the learning curve for clients — **without changing the subsystems themselves**.

Use the **Facade Pattern** when you want to **simplify interactions** with complex systems by exposing a **unified, easy-to-use interface**.

---

**Happy Designing!** 🏢✨


---


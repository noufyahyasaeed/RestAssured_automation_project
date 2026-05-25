# REST Assured Automation Project

⚠️ **STATUS: IN PROGRESS**

## 📝 About the Project

This project is dedicated to mastering API test automation. It implements automated testing across the full lifecycle of
**CRUD** (Create, Read, Update, Delete) operations to validate API behavior and response consistency.

### 🛠️ Tech Stack

* **Language:** Java
* **Testing Framework:** TestNG
* **API Automation Client:** REST Assured

---

## 💡 Core REST Assured Concepts

### **Gherkin Keywords**

REST Assured utilizes BDD (Behavior-Driven Development) style Gherkin keywords to structure test actions as readable
methods:

* **`given()`** — *Prerequisites*
    * Used to set up request metadata such as Content-Type, Authentication tokens, Cookies, and Parameters.
    * *Note: The `given()` block is optional. If your request requires no prerequisites, you can start the chain
      directly with `when()`.*
* **`when()`** — *Actions*
    * Triggers the actual HTTP request method (e.g., `GET`, `POST`, `PUT`, `DELETE`) to the specified endpoint path.
* **`then()`** — *Validations*
    * Used to assert response outcomes, such as verifying HTTP status codes, validating response body data, checking
      headers, or extracting values for downstream tests.

### **Required Static Imports**

To use these fluent methods directly without writing the class names every time, you must include these static imports
at the top of your Java test files:

```java
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
```

### **Test Configuration Note**

In this framework, the key difference between a standard Java helper method and an executable automation script is the
@Test annotation placed directly above the method signature.
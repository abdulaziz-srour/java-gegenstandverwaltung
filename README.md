# Java Inventory & Transfer Management

A console-based object-oriented application to manage people, their belongings, and the transfer of items between them. The system strictly enforces business rules regarding weight limits and inventory capacities.

## Tech Stack
* **Language:** Java (JDK 25)
* **Tools:** IntelliJ IDEA, Git

## Key Features & Quality Assurance
* **Clean Data Models:** Clear separation of entities (`Person`, `Gegenstand`) and UI/Application logic (`Applikation`).
* **Strict Business Rules:** The system actively enforces constraints before any item transfer:
  * Maximum weight capacity of 10 kg per person.
  * Maximum inventory size of 5 items per person.
  * Transfer limit of 6 items per person, per session.
* **Transactional Safety:** If an item transfer fails (e.g., the target person has reached their weight limit), the item is safely returned to the original owner's inventory to prevent data loss.
* **Robust Input Handling:** Uses continuous `while(true)` loops and `try-catch` blocks to gracefully handle `InputMismatchExceptions` and invalid menu selections.


## How to Run

**Option 1: Terminal / CLI**
1. Clone the repository and navigate to the source folder:
   ```bash
   cd src/gegenstandverwaltung
2. Compile the Java files:
    ```bash
    javac *.java
3. Go back to the root `src` folder and run the app:
    ```bash
    cd ..
    java gegenstandverwaltung.Applikation
**Option 2: IDE**

Open the project in IntelliJ IDEA or Eclipse and run the `Applikation.java` file. Follow the interactive console menu.

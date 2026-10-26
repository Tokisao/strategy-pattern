# Strategy Pattern — Navigation / Route Planning

## Name: Zharylgapova Dayana <br>
## Group: SE-2538

A small Java project demonstrating the **Strategy** behavioral design pattern
on a navigation domain.
---

## Project Structure

```
strategy-navigator/
├── README.md
└── src/
    ├── RouteStrategy.java        # Strategy interface (common algorithm contract)
    ├── CarRouteStrategy.java     # Concrete strategy: car route
    ├── WalkRouteStrategy.java    # Concrete strategy: walking route
    ├── CycleRouteStrategy.java   # Concrete strategy: cycling route
    ├── Navigator.java            # Context: holds a strategy and delegates to it
    └── Main.java                 # Client: selects and switches strategies at runtime
```

### Roles

| File | Pattern role | Responsibility |
|---|---|---|
| `RouteStrategy.java` | Strategy (interface) | Declares `buildRoute(origin, destination)` |
| `CarRouteStrategy.java` | Concrete Strategy | Builds a car route |
| `WalkRouteStrategy.java` | Concrete Strategy | Builds a walking route |
| `CycleRouteStrategy.java` | Concrete Strategy | Builds a cycling route |
| `Navigator.java` | Context | Holds a `RouteStrategy` and delegates `planRoute` to it |
| `Main.java` | Client | Creates a `Navigator`, selects and switches strategies |

---

## Requirements

- **JDK 17** or newer (the code only uses standard Java features; any JDK ≥ 8 works).

Check your version:

```bash
java -version
javac -version
```

---

## How to Build and Run

### Command line (no build tool required)

From the project root:

```bash
# 1. Compile all sources into the out/ directory
javac -d out src/*.java

# 2. Run the client
java -cp out Main
```

Expected output (order may vary depending on your `Main`):

```
Car route from Dormitory to Campus via highways (fastest, tolls may apply).
Walking route from Dormitory to Campus via pedestrian paths (shortest distance).
Cycling route from Dormitory to Campus via bike lanes (balanced speed and safety).
```

## How to Add a New Strategy

Adding a new routing algorithm requires **one new class** and **zero changes to `Navigator`** — this is the Open–Closed Principle in action.

### Step 1 — Create a new class that implements `RouteStrategy`

Create `src/BoatRouteStrategy.java`:

```java
public class BoatRouteStrategy implements RouteStrategy {
    @Override
    public String buildRoute(String origin, String destination) {
        return "Boat route from " + origin + " to " + destination + " via waterways.";
    }
}
```

### Step 2 — Use it from the client

In `src/Main.java`, pass it to the navigator:

```java
Navigator navigator = new Navigator(new BoatRouteStrategy());
System.out.println(navigator.planRoute("Dormitory", "Campus"));
```

Or switch to it at runtime:

```java
navigator.setStrategy(new BoatRouteStrategy());
System.out.println(navigator.planRoute("Dormitory", "Campus"));
```

### Step 3 — Recompile and run

```bash
javac -d out src/*.java
java -cp out Main
```

`Navigator.java` is **not modified** — it only knows the `RouteStrategy` interface.

---

## Design Notes

- **No conditional logic on strategy type.** `Navigator.planRoute()` simply calls
  `strategy.buildRoute(...)`. There is no `if`/`switch` anywhere in the context.
- **Context is algorithm-agnostic.** `Navigator` imports and references only
  `RouteStrategy`, never any concrete strategy.
- **Runtime switching.** `Navigator.setStrategy(...)` allows changing the
  algorithm at runtime.
- **Strategy vs. State.** This problem is solved with **Strategy**, not **State**:
  the routing algorithm is chosen by the **client** and does not represent an
  internal lifecycle/state transition of the `Navigator`.

---

## Commit History

The repository history is incremental and reflects the construction order:

```
add gitignore
add strategy interface
add car concrete strategy
add walk concrete strategy
add cycle concrete strategy
add navigator context
add main client
add readme
```
---
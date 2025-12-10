# F1 Race Season Manager - Refactored Package Structure

## Overview
Your F1 Race project has been successfully reorganized into a proper package structure for better code organization and maintainability.

## Package Structure

```
src/
├── com/
│   └── f1race/
│       ├── algorithm/           # Algorithms for data manipulation
│       │   ├── AVLNode.java      # AVL tree node
│       │   ├── AVLTree.java      # AVL tree implementation
│       │   └── Dijkstra.java     # Dijkstra's shortest path algorithm
│       │
│       ├── core/                 # Core domain models
│       │   ├── Driver.java       # Driver class with statistics
│       │   ├── Team.java         # Team class with driver management
│       │   ├── Edge.java         # Graph edge for track connections
│       │   └── Graph.java        # Graph structure for track routing
│       │
│       ├── race/                 # Race management logic
│       │   ├── manageRace.java   # Main race management system
│       │   └── raceResults.java  # Individual race result tracking
│       │
│       └── ui/                   # User interface
│           ├── Main.java         # Console UI entry point
│           └── App.java          # JavaFX GUI application
```

## Package Descriptions

### `com.f1race.algorithm`
- **Purpose**: Contains algorithmic implementations for efficient data processing
- **Classes**:
  - `AVLTree`: Self-balancing binary search tree for maintaining sorted driver standings
  - `AVLNode`: Node structure for the AVL tree
  - `Dijkstra`: Finds shortest path between F1 tracks

### `com.f1race.core`
- **Purpose**: Core domain objects representing the problem domain
- **Classes**:
  - `Driver`: Represents an F1 driver with points, wins, podiums
  - `Team`: Represents an F1 team with multiple drivers
  - `Graph`: Represents track connections for routing
  - `Edge`: Represents connection between tracks with distance

### `com.f1race.race`
- **Purpose**: Business logic for managing races and seasons
- **Classes**:
  - `manageRace`: Central class managing drivers, teams, and race results
  - `raceResults`: Tracks individual race outcomes and updates standings

### `com.f1race.ui`
- **Purpose**: User interface layer (console and GUI)
- **Classes**:
  - `Main`: Console-based interface
  - `App`: JavaFX-based graphical interface

## How to Compile

### Compile all packages
```bash
# Core, algorithm, and race packages (no external dependencies)
javac -d bin src/com/f1race/algorithm/*.java src/com/f1race/core/*.java src/com/f1race/race/*.java

# UI packages (requires JavaFX)
javac --module-path javafx-sdk-25.0.1/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp bin -d bin src/com/f1race/ui/*.java
```

## How to Run

### Console Application
```bash
java -cp bin com.f1race.ui.Main
```

### JavaFX GUI Application
```bash
java --module-path javafx-sdk-25.0.1/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp bin com.f1race.ui.App
```

## Benefits of This Structure

1. **Separation of Concerns**: Each package has a specific responsibility
2. **Scalability**: Easy to add new features in appropriate packages
3. **Maintainability**: Code is organized logically for easier navigation
4. **Reusability**: Core algorithms can be reused in multiple UI implementations
5. **Testing**: Each package can be tested independently
6. **Industry Standard**: Follows Java naming conventions (`com.company.project.module`)

## Import Examples

When importing classes between packages:

```java
// In com.f1race.ui.Main
import com.f1race.core.Driver;
import com.f1race.core.Team;
import com.f1race.race.manageRace;

// In com.f1race.race.manageRace
import com.f1race.core.Driver;
import com.f1race.core.Team;
import com.f1race.core.Graph;
import com.f1race.algorithm.AVLTree;
import com.f1race.algorithm.Dijkstra;
```

## CSV File Format

The driver input CSV should be located at:
- `src/driverinput.csv` (automatic file picker when running console app)

Format:
```
DriverName,TeamName,CarNumber,Nationality,Points,Wins,Podiums
Max Verstappen,Red Bull,1,Dutch,450,15,20
Lewis Hamilton,Mercedes,44,British,420,10,18
```

## Next Steps

1. **Test the application**: Run both console and GUI versions
2. **Add more features**: You can now easily extend functionality in appropriate packages
3. **Create unit tests**: Test individual packages (e.g., `src/com/f1race/algorithm/AVLTreeTest.java`)
4. **Expand the model**: Add new classes like `Season.java`, `Circuit.java`, etc. as needed

---

**Last Updated**: December 10, 2025
**Refactored Structure**: All Java files organized into packages following industry standards

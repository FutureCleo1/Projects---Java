# F1 Race Season Manager - Build & Run Guide

## Quick Start

### Console Application (No GUI)
```bash
./run-console.sh
```

### JavaFX GUI Application
```bash
./run-gui.sh
```

## Build Commands

### Build All (Core + UI)
```bash
# Compile core modules
javac -d bin src/com/f1race/algorithm/*.java src/com/f1race/core/*.java src/com/f1race/race/*.java

# Compile UI (requires JavaFX)
javac --module-path javafx-sdk-25.0.1/lib \
      --add-modules javafx.controls,javafx.fxml \
      -cp bin -d bin src/com/f1race/ui/*.java
```

### Build Core Only (No JavaFX Dependency)
```bash
javac -d bin src/com/f1race/algorithm/*.java src/com/f1race/core/*.java src/com/f1race/race/*.java
```

## Run Commands

### Run Console UI
```bash
java -cp bin com.f1race.ui.Main
```

### Run JavaFX GUI
```bash
java --enable-native-access=javafx.graphics \
     --module-path javafx-sdk-25.0.1/lib \
     --add-modules javafx.controls,javafx.fxml \
     -cp bin com.f1race.ui.App
```

## What Each Package Does

| Package | Purpose | Classes |
|---------|---------|---------|
| `com.f1race.algorithm` | Data structure algorithms | AVLTree, AVLNode, Dijkstra |
| `com.f1race.core` | Domain models | Driver, Team, Graph, Edge |
| `com.f1race.race` | Race/season management | manageRace, raceResults |
| `com.f1race.ui` | User interfaces | Main (console), App (JavaFX) |

## Directory Structure

```
f1projectfx/
├── bin/                           # Compiled .class files
│   └── com/f1race/...
├── src/                           # Source code
│   ├── driverinput.csv           # Driver data
│   └── com/f1race/...            # Packages
├── javafx-sdk-25.0.1/            # JavaFX SDK
├── PACKAGE_STRUCTURE.md          # Detailed package info
├── BUILD_RUN_GUIDE.md            # This file
├── run-gui.sh                    # Launch GUI app
└── run-console.sh                # Launch console app
```

## Input Files

**Driver CSV Format** (`src/driverinput.csv`):
```csv
DriverName,TeamName,CarNumber,Nationality,Points,Wins,Podiums
Max Verstappen,Red Bull,1,Dutch,450,15,20
Lewis Hamilton,Mercedes,44,British,420,10,18
```

## Features

### Console UI
- ✅ Load drivers from CSV file (file picker dialog)
- ✅ View driver standings (sorted by points/wins)
- ✅ View team information
- ✅ Add race results
- ✅ View current standings
- ✅ Season summary

### GUI App (JavaFX)
- ✅ Load drivers CSV from file path
- ✅ Add race results via dialogs
- ✅ View standings in popup
- ✅ Track routing with Dijkstra's algorithm
- ✅ Interactive button-based interface

## Troubleshooting

### App doesn't start
1. Ensure `bin/` directory exists: `mkdir -p bin`
2. Rebuild: Run the appropriate build command above
3. Check Java version: `java -version` (should be 17+)

### JavaFX not found
1. Verify path exists: `ls javafx-sdk-25.0.1/lib/javafx.controls.jar`
2. The `--module-path` and `--add-modules` flags are required for JavaFX
3. Use `run-gui.sh` script which handles this automatically

### File not found when loading CSV
- Place your CSV file at: `src/driverinput.csv`
- Or use the file picker to select from anywhere

## IDE Integration (VS Code / IntelliJ)

Add to `.classpath` or project configuration:
```
Classpath: bin
Module path: javafx-sdk-25.0.1/lib
Modules: javafx.controls, javafx.fxml
```

---

**Last Updated**: December 10, 2025
**Java Version**: 17+ required
**JavaFX Version**: 25.0.1

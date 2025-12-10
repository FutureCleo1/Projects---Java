Forumla 1 Smart Library This project utilizes java and javaFx (GUI) to create a Formula 1 Season Tracker. It has drivers info, team info, race results, point tracking, current poll standing(updates after each race)

Project Structure 
src/
├── com/
│   └── f1race/
│       ├── algorithm/           
│       │   ├── AVLNode.java      
│       │   ├── AVLTree.java    
│       │   └── Dijkstra.java   
│       │
│       ├── core/            
│       │   ├── Driver.java     
│       │   ├── Team.java        
│       │   ├── Edge.java        
│       │   └── Graph.java       
│       │
│       ├── race/            
│       │   ├── manageRace.java  
│       │   └── raceResults.java  
│       │
│       └── ui/                 
│           ├── Main.java       
│           └── App.java         


  - AVLTree: Self-balancing binary search tree for maintaining sorted driver standings
  - AVLNode: Node structure for the AVL tree
  - Dijkstra: Finds shortest path between F1 tracks
  - Driver: Represents an F1 driver with points, wins, podiums
  - Team: Represents an F1 team with multiple drivers
  - Graph: Represents track connections for routing
  - Edge: Represents connection between tracks with distance
  - manageRace: Central class managing drivers, teams, and race results
  - raceResults: Tracks individual race outcomes and updates standings
  - Main: Console-based interface
  - App: JavaFX-based graphical interface

Downloads
- make sure your java is up to date
- download JavaFX (GUI)

How to Compile
- javac -d bin src/com/f1race/algorithm/*.java src/com/f1race/core/*.java src/com/f1race/race/*.java

How to Run
-java -cp src Main

Downloads
* make sure your java is up to date
* download JavaFX (GUI)

* Utilized AI to help with the problem on making the GUI work (from making sure it is dowloaded to what the terminal say whats wrong with it and fixing it) and help toi make a package
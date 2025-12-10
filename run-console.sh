#!/bin/bash
# Script to run F1 Season Manager Console

cd "$(dirname "$0")" || exit 1

echo "Compiling if needed..."
javac -d bin src/com/f1race/algorithm/*.java src/com/f1race/core/*.java src/com/f1race/race/*.java 2>/dev/null

echo "Launching F1 Season Manager Console..."
java -cp bin com.f1race.ui.Main

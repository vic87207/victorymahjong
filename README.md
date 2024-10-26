# Mahjong Game (Ongoing Project)

This project is an ongoing development of a single-player Mahjong game written in Java. The player competes against AI opponents by drawing, discarding, and forming hands with Mahjong tiles, according to Taiwan Mahjong rules.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Current Structure](#current-structure)
- [Planned Features](#planned-features)


## Features

The project is currently under development and includes the following implemented components:

- **Tile and TileSet Classes**: Manages the structure and functionality of individual tiles and the full set of Mahjong tiles, including flowers and other special tiles.
- **Player Class**: Manages player-specific actions, such as drawing, discarding, sorting, and handling flower tiles.
- **Display and Game Loop**:
    - `TerminalDisplay`: Handles basic terminal-based display of player hands.
    - `TestLoop`: Provides a basic run loop to simulate gameplay, allowing players to draw, discard, and interact with the game in a text-based interface.
- **Hand Management**: Implements various tile operations, including sorting hands and identifying sets.

## Installation

1. **Clone the Repository**:
   ```bash
   https://github.com/vic87207/victorymahjong.git

2. **Open the Project**:
Open the cloned project in your preferred Java IDE (e.g., IntelliJ IDEA).
3. **Build and Run**: 
Build the project and run the Main class.


**Requirements**:

Java 8 or later

## Usage
1. **Running the Game**:

    - After running the Main class, the game will launch in a terminal-based interface.
    -   Use prompts to draw, discard, and organize your tiles.
2. **Game Structure**:

    - The initial implementation allows basic tile handling and player actions. Game logic includes identifying flowers, managing hands, and providing basic gameplay flow through terminal interactions.

    - 
## Current Structure
**Classes**
1. Main: Entry point for the game, sets up and initializes gameplay. 
2. Player: Manages player-specific actions, including drawing and discarding tiles. 
3. Tile: Represents individual Mahjong tiles with suit and value attributes. 
4. TileSet: Initializes a complete set of Mahjong tiles and handles shuffling and tile drawing. 
5. TerminalDisplay: Provides methods to display the player's hand in ASCII art format. 
6. TestLoop: Simulates a basic game loop, allowing for iterative testing and development.

## Planned Features
The project is in progress, and several features are yet to be implemented or improved:

- GUI Integration: Move from a terminal-based display to a graphical user interface for more engaging gameplay.
- AI Opponents: Develop logic for AI players to simulate multiplayer gameplay.
- Scoring and Rules: Implement full Taiwan Mahjong rules, including scoring and win conditions.
- Multiplayer Support: Explore options for online or local multiplayer modes.

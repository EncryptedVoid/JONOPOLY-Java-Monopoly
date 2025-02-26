# Property Trading Board Game

![Game Preview](https://via.placeholder.com/800x400?text=Property+Trading+Game)

## Project Overview

This is an object-oriented implementation of a classic property trading board game, similar to Monopoly. The game allows players to buy properties, collect rent, build developments, and strategize to become the wealthiest player.

## Features

- **Player Management**: Create and manage players with unique avatars
- **Property System**: Multiple types of purchasable assets
  - Land properties (with houses and hotels)
  - Railroads
  - Utilities
- **Economic System**: Buy, sell, mortgage, and trade properties
- **Development**: Build houses and hotels to increase property values
- **Game Mechanics**: Movement around the board, chance cards, and jail system

## Class Structure

The project follows an object-oriented design with a clear class hierarchy:

### Core Classes

- **`Card`**: Base class for all cards in the game
  - **`Asset`**: Abstract class extending Card for all purchasable assets
    - **`Land`**: Properties where houses and hotels can be built
    - **`Railroad`**: Transportation properties with escalating rent based on ownership
    - **`Utility`**: Service properties with rent based on dice roll and ownership count
  - **`ActionCard`**: (Planned) Cards that trigger specific game events

- **`Player`**: Represents a game participant with assets and bank balance
- **`Game`**: (In development) Main game controller managing gameplay and rules

## Key Features Implementation

### Asset Management

Assets are the core of the game, with different types providing varied gameplay dynamics:

- **Land Properties**:
  - Grouped by company (color sets)
  - Buildable with houses and hotels
  - Rent increases with development
  - Construction costs escalate with each development

- **Utilities**:
  - Rent calculated based on dice roll and number of utilities owned
  - Provides strategic value when owned as a set

- **Railroads**:
  - (Planned) Rent increases with number of railroads owned

### Player Mechanics

Players can:
- Purchase available properties
- Collect rent from other players
- Build developments on properties
- Mortgage properties for quick cash
- Trade with other players (planned)

### Game Logic

The game logic includes:
- Turn-based gameplay
- Movement around the board
- Property acquisition
- Rent collection
- Development construction

## Technical Implementation Details

### Land Class

The `Land` class provides a robust implementation for properties:

```java
// Building houses
public boolean buildHouse(Player player) {
    if (sufficientBalance(player)) {
        housesBuilt++;
        constructionPrice *= 1.5F;
        return true;
    }
    return false;
}

// Building hotels
public boolean buildHotel(Player player) {
    if (canBuildHotel() && sufficientBalance(player)) {
        hotelsBuilt++;
        housesBuilt -= hotelConstructionRequirement;
        constructionPrice *= 1.85F;
        return true;
    }
    return false;
}
```

### Utility Class

Utilities implement a unique rent calculation system:

```java
// In the Utility class
private static int rentMultiplier;
private static int ownedUtilities;

// Rent calculation will be based on dice roll * rentMultiplier
// The rentMultiplier increases as more utilities are owned
```

## Planned Enhancements

Future development plans include:

- **Dice System**: Implementation of dice rolling mechanics
- **Action Cards**: Chance and Community Chest cards
- **Trading System**: Property trading between players
- **Bankruptcy Handling**: Game mechanics for player elimination
- **UI Development**: Graphical user interface for the game
- **Network Play**: Multiplayer capabilities
- **Game Saving**: Ability to save and resume games

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Running the Game

*Note: The game is currently in development and not yet fully playable.*

Once complete, you will be able to:

1. Compile the Java files
2. Run the Game class to start a new game
3. Follow on-screen instructions to play

## Development Status

This project is currently in active development. Core classes and game mechanics are being implemented, with focus on the following:

- [x] Basic class structure
- [x] Property system implementation
- [x] Player management
- [ ] Game flow and rules
- [ ] User interface
- [ ] Testing and balancing

## Acknowledgments

- Inspired by the classic Monopoly board game
- Built as a programming exercise to demonstrate object-oriented design principles
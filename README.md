**Problem**

Paper-Rock-Scissors is a game for two players. Each player simultaneously opens his/her hand to display
a symbol:
• Fist equals rock
• Open hand equals paper
• Showing the index and middle finger equals scissors.
The winner is determined by the following schema:
• Paper beats (wraps) rock
• Rock beats (blunts) scissors
• Scissors beats (cuts) paper.

**Solution**
- The solution is implemented in Java with ~70% unit test coverage. 
- The program is run from the command line.
- Run the src/main/java/Main.java file to start the program. The program will ask for the name and number of rounds user wants to play.
- The user will then be asked to enter a choice for each round. The computer will randomly generate a choice for each
  round. The winner of each round will be displayed.
- At the end when all rounds are played , program will show the overall winner of the game consolidating results from all round.
- User has the option to exit the game by simply typing "exit" in console in middle of game.
- Java version used is 11

**Libraries used**
- JUnit for unit testing
- Maven for build and dependency management
- Mockito for mocking

**Properties of the code**
1. Object-Oriented Design: Code is organized into classes and objects , promoting modular and object-oriented approach
2. Encapsulation: Several classes(example: RockPaperScissorsFactory.java) encapsulate creation and various other functionality.
3. Interfaces and Abstraction: Several interfaces like Player, Move, MoveEvaluator etc allows abstraction and separations of concern.
4. Extensibility and Reusability: Code is written in such a way that it is future extensible (example: new Moves can be introduced without much changes,
new RuleEngine implementation can easily be added etc.) and reusable as well.
5. Factory Creation Pattern: Used in RockPaperScissorsFactory
6. Dependency Injection: Example: Player implementations , Game implementation
7. Single Responsibility Principle: Example: RuleEngine only does the work of determining winner. Game class manages game flow


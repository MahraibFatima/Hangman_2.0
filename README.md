## Abstract

This is an advanced GUI-based HangmanGame game built as an enhancement to the earlier [CLI-based HangmanGame project](https://github.com/MahraibFatima/HangMan). 
The game introduces a visually engaging user interface, making it more interactive and enjoyable for players. 
Players can guess letters to complete a hidden word, with each incorrect guess resulting in a visual update to the hangman drawing.

## How to Play
1. Start the Game:
    - Run the application. The GUI window will open with a welcome screen and a "Start Game" button.
2. Game Mechanics:
    - A random word is selected and displayed as underscores (e.g., _ _ _ _ _).
3. Use the on-screen keyboard or your physical keyboard to guess letters.
    - Correct guesses reveal the letter in the word.
    - Incorrect guesses add a penalty.
4. Winning the Game:
    - Successfully guess all the letters in the word before the hangman is fully drawn.
5. Losing the Game:
    - If the hangman is fully drawn before the word is guessed, the game ends.

## Technology Stack
1. Programming Language: Java (Swing/JavaFX for GUI)
2. IDE: IntelliJ IDEA
3. Libraries:
    - JavaFX for enhanced GUI design.
    - json for handling custom word lists (JSON format). 

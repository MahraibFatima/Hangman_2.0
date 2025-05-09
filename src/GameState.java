import java.io.Serializable;

public class GameState implements Serializable {
    private String player1;
    private String player2;
    private String secretWord= "JAVA";
    private int currentRound = 1;
    private int player1Score = 0;
    private int player2Score = 0;

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord.toUpperCase();
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void incrementRound() {
        this.currentRound++;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void incrementPlayer1Score() {
        this.player1Score++;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void incrementPlayer2Score() {
        this.player2Score++;
    }

    public void resetGame() {
        this.secretWord = null;
    }

    public void resetAll() {
        this.player1 = null;
        this.player2 = null;
        this.secretWord = null;
        this.currentRound = 1;
        this.player1Score = 0;
        this.player2Score = 0;
    }
}
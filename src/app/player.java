package app;

public abstract class player {
    protected board gameBoard;
    protected String playerName;
    protected int playerSymbol;

    public player(board gameBoard, int playerSymbol, String playerName){
        this.gameBoard = gameBoard;
        this.playerSymbol = playerSymbol;
        this.playerName = playerName;
    }
    
    public abstract void play(board gameBoard);
    
    @Override
    public String toString() {
        return this.playerName;
    }
}

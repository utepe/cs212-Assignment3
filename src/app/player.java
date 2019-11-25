package app;

/**
 * Absract Class Player implements Global Interface
 * Contains absract method play
 * @author Uygur Tepe 105006877
 */
public abstract class player {
    protected board gameBoard;
    protected String playerName;
    protected int playerSymbol;
    
    /** 
     * Overloaded Constructor of Player Class
     * @param gameBoard
     * @param playerSymbol
     * @param playerName
     */
    public player(board gameBoard, int playerSymbol, String playerName){
        this.gameBoard = gameBoard;
        this.playerSymbol = playerSymbol;
        this.playerName = playerName;
    }
    
    /** 
     * Abstract method Play
     * @param gameboard
     */
    public abstract void play(board gameBoard);
    
    /** 
     * @Override
     * toString method
     * @return String of playerName
     */
    public String toString() {
        return this.playerName;
    }
}

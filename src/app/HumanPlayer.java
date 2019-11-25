package app;

import java.util.Scanner;

/**
 * HumanPlayer class extend abstract class Player implements Global Interface
 * @author Uygur Tepe 105006877
 */
public class HumanPlayer extends player implements global{

    /** 
     * Overloaded Constructor of HumanPlayer Class
     * @param gameBoard
     * @param playerSymbol
     * @param playerName
     * call super constructor
     */
    public HumanPlayer(board gameBoard, int playerSymbol, String playerName) {
        super(gameBoard, playerSymbol, playerName);
	}
 
    /** 
     * @Override of abstract method play extended from Player Class
     * Method which asks user which move they want to play
     * checks if selected move is valid
     * @param gameBoard
     */
    public void play(board gameBoard) {
        Scanner scan = new Scanner(System.in);
        super.gameBoard = gameBoard;
        boolean validMove;
        do{
            System.out.println("Game: Please enter your move by selecting a number from the available areas: ");
            gameBoard.displayPlayerSectionBoard();
            validMove = gameBoard.makeMove(scan.nextInt(), this.playerSymbol);
            if(validMove == false){
                System.out.println("Game: Invalid Move! Try again.");
            }
        }while (!validMove);
    }

}
package app;

import java.util.Scanner;

public class HumanPlayer extends player implements global{

	public HumanPlayer(board gameBoard, int playerSymbol, String playerName) {
        super(gameBoard, playerSymbol, playerName);
	}

    @Override
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
package app;

import java.util.Random;

public class EasyAIPlayer extends player implements global{

    public EasyAIPlayer(board gameBoard, int playerSymbol, String playerName) {
        super(gameBoard, playerSymbol, playerName);
    }

    @Override
    public void play(board gameBoard) {
        super.gameBoard = gameBoard;
        boolean validMove;
        do{
            System.out.println("Game: Please enter your move by selecting a number from the available areas: ");
            gameBoard.displayPlayerSectionBoard();
            validMove = gameBoard.makeMove(getRandomMove(gameBoard), this.playerSymbol);
            if(validMove == false){
                System.out.println("Game: Invalid Move! Try again.");
            }
        }while (!validMove);
    }

    public int getRandomMove(board gameBoard){
        boolean moveOK = false;
        do{
            int posCounter = 0;
            Random randomMove = new Random();
            int randRow = randomMove.nextInt(3);
            int randCol = randomMove.nextInt(3);
            if(this.gameBoard.blocks[randRow][randCol].getState() == 0){
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        posCounter++;
                        if(randRow == i && randCol == j){
                            return posCounter;
                        }
                    }
                }
            }
        }while(!moveOK);
        return 0;
    }

}

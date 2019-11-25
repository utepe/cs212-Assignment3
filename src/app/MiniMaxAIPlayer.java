package app;

public class MiniMaxAIPlayer extends player implements global{
    
	public MiniMaxAIPlayer(board gameBoard, int playerSymbol, String playerName) {
        super(gameBoard, playerSymbol, playerName);
    }

    @Override
    public void play(board gameBoard) {
        super.gameBoard = gameBoard;
        boolean validMove;
        do{
            System.out.println("Game: Please enter your move by selecting a number from the available areas: ");
            gameBoard.displayPlayerSectionBoard();
            validMove = gameBoard.makeMove(findBestMove(), this.playerSymbol);
            if(validMove == false){
                System.out.println("Game: Invalid Move! Try again.");
            }
        }while (!validMove);
    }

    private boolean isRemaingMoves(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.gameBoard.blocks[i][j].getState() == 0)
                    return true;
            }
        }
        return false;
    }

    private int evaluatePossibilities(){
        int opponentSymbol;
        if(this.playerSymbol == 3){
            opponentSymbol = 2;
        }
        else{
            opponentSymbol = 3;
        }
        
        //check rows
        for(int i = 0; i < 3; i++){
            if(this.gameBoard.checkRow(i) == this.playerSymbol){
                return +10;
            }
            else if(this.gameBoard.checkRow(i) == opponentSymbol){
                return -10;
            }
        }
        //check cols
        for(int i = 0; i < 3; i++){
            if(this.gameBoard.checkCol(i) == this.playerSymbol){
                return +10;
            }
            else if(this.gameBoard.checkCol(i) == opponentSymbol){
                return -10;
            }
        }

        if(this.gameBoard.checkDiagonals() == this.playerSymbol){
            return +10;
        }
        else if(this.gameBoard.checkDiagonals() == opponentSymbol){
            return -10;
        }

        return 0;
    }

    private int minimax(int depth, boolean isMax){
        int score = evaluatePossibilities();

        if(score == -10){
            return score;
        }
        if(score == 10){
            return score;
        }

        if(isRemaingMoves() == false){
            return 0;
        }

        if(isMax){
            int bestCase = -1000;

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(this.gameBoard.blocks[i][j].getState() == 0){
                        this.gameBoard.blocks[i][j].setState(this.playerSymbol);

                        bestCase = Math.max(bestCase, minimax(depth + 1, !isMax));

                        this.gameBoard.blocks[i][j].undoState();
                    }
                }
            }
            return bestCase;
        }
        else{
            int bestCase = 1000;
            int opponentSymbol;
            if(this.playerSymbol == 3){
                opponentSymbol = 2;
            }
            else{
                opponentSymbol = 3;
            }
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(this.gameBoard.blocks[i][j].getState() == 0){
                        this.gameBoard.blocks[i][j].setState(opponentSymbol);

                        bestCase = Math.min(bestCase, minimax(depth + 1, !isMax));

                        this.gameBoard.blocks[i][j].undoState();
                    }
                }
            }
            return bestCase;
        }
    }

    private int findBestMove(){
        int bestCase = -1000;
        int counter = 0;
        int bestMove = -1;
        //int boardPos = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                counter++;
                if(this.gameBoard.blocks[i][j].getState() == 0){
                    this.gameBoard.blocks[i][j].setState(this.playerSymbol);

                    int moveCase = minimax(0, false);

                    this.gameBoard.blocks[i][j].undoState();

                    if(moveCase > bestCase){
                        bestMove = counter;
                        bestCase = moveCase;
                    }
                }
            }
        }
        //System.out.println(bestMove);
        return bestMove;
    }


    
}
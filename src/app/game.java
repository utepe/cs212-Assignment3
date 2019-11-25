package app;

import java.util.*;

class game implements global{
    private boolean done;
    private board gameBoard;
    private player playerO;
    private player playerX; 
    private int turn;

    public game(){
        this.done = false;
        this.gameBoard = new board();
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String player1;
        String player2;
        int key;

        System.out.println("xoxo TicTacToe xoxo");
        System.out.println("--------------------");
        //System.out.println("");

        while(!this.done){
            System.out.println("Game: Please select a game option: ");
            System.out.println("[1] Human vs Human");
            System.out.println("[2] Human vs Easy AI");
            System.out.println("[3] Human vs Hard AI");
            System.out.println("[4] AI vs AI");
            key = scan.nextInt();
            
            switch (key) {
                case 1:
                    System.out.println("\nEnter the name of PlayerO: ");
                    scan.nextLine();
                    player1 = scan.nextLine();
                    System.out.println("Enter the name of PlayerX: ");
                    player2 = sc.nextLine();
                    this.done = true;
                    break;
                case 2:
                    System.out.println("\nEnter the name of Human PlayerO: ");
                    scan.nextLine();
                    player1 = scan.nextLine();
                    System.out.println("Enter the name of AI PlayerX: ");
                    player2 = sc.nextLine();
                    this.done = true;
                    break;
                case 3:
                    System.out.println("\nEnter the name of Human PlayerO: ");
                    scan.nextLine();
                    player1 = scan.nextLine();
                    System.out.println("Enter the name of AI PlayerX: ");
                    player2 = sc.nextLine();
                    this.done = true;
                    break;
                case 4:
                    System.out.println("\nEnter the name of AI PlayerO: ");
                    scan.nextLine();
                    player1 = scan.nextLine();
                    System.out.println("Enter the name of AI PlayerX: ");
                    player2 = sc.nextLine();
                    this.done = true;
                    break;
                default:
                    System.out.println("Game: Please enter a valid choice.");
                    continue;
            }
            if(key == 1){
                this.playerO = new HumanPlayer(this.gameBoard, 2, player1);
                this.playerX = new HumanPlayer(this.gameBoard, 3, player2);
            }
            else if(key == 2){
                this.playerO = new HumanPlayer(this.gameBoard, 2, player1);
                this.playerX = new EasyAIPlayer(this.gameBoard, 3, player2);
            }
            else if(key == 3){
                this.playerO = new HumanPlayer(this.gameBoard, 2, player1);
                this.playerX = new MiniMaxAIPlayer(this.gameBoard, 3, player2);
            }
            else{
                this.playerO = new EasyAIPlayer(this.gameBoard, 2, player1);
                this.playerX = new MiniMaxAIPlayer(this.gameBoard, 3, player2);
            }
            System.out.println("Game: Game will begin now: " + player1 + " vs. " + player2);
        }
    }

    public void start(){
        Random coin = new Random();
        int turnChanger = 0;
        this.turn = coin.nextInt(2) + 1;
        
        if(this.turn == 1){
            System.out.println("Game: " + this.playerO.playerName + " wins the coin toss... O will start");
        }
        else{
            System.out.println("Game: " + this.playerX.playerName + " wins the coin toss... X will start");
        }

        while(turnChanger == 0){
            if(this.turn == 1){
                System.out.println("Game: It is PlayerO's Turn, " + this.playerO.playerName + " play your turn!");
                this.playerO.play(this.gameBoard);
            }
            else{
                System.out.println("Game: It is PlayerX's Turn, " + this.playerX.playerName + " play your turn!");
                this.playerX.play(this.gameBoard);
            }

            if(this.gameBoard.getState() != 0){
                turnChanger = 1;
            }
            if(turnChanger == 0){
                if(this.turn == 1){
                    this.turn = 2;
                }
                else{
                    this.turn = 1;
                }
            }
        }
        System.out.println("");
        this.gameBoard.displayBoard();
        if(this.gameBoard.getState() == 1){
            System.out.println("Game: There is a Draw!");
        }
        else if(this.gameBoard.getState() == 2){
            System.out.println("Game: The Winner is PlayerO, " + this.playerO.playerName);
        }
        else{
            System.out.println("Game: The Winner is PlayerX, " + this.playerX.playerName);
        }
    }
}
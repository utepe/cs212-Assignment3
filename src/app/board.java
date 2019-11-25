package app;

public class board implements global{
    public blocks[][] blocks;
    private int state;

    public board(){
        this.state = 0;
        this.blocks = new blocks[3][3];
        for(int i = 0; i < 3; i++){     //initizalize board
            for(int j = 0; j < 3; j++){
                this.blocks[i][j] = new blocks();
            }
        }
    }

    public void displayBoard(){
        for(int i = 0; i < 3; i++){
            System.out.println("   |   |    ");
            for(int j = 0; j < 3; j++){
                System.out.print(" " + this.blocks[i][j] + " ");
                if(j == 2){
                    System.out.println("");;
                }
                else
                    System.out.print("|");
            }
            if (i != 2)
                System.out.println("___|___|___");
            else
                System.out.println("   |   |   ");
        }
    }

    public void displayPlayerSectionBoard(){
        int boxVal = 1;
        for(int i = 0; i < 3; i++){
            System.out.println("   |   |    ");
            for(int j = 0; j < 3; j++){
                if(this.blocks[i][j].getState() == 0){
                    System.out.print(" " + boxVal + " ");
                }
                else{
                    System.out.print(" " + this.blocks[i][j] + " ");
                }
                boxVal++;
                if(j == 2){
                    System.out.println("");;
                }
                else
                    System.out.print("|");
            }
            if (i != 2)
                System.out.println("___|___|___");
            else
                System.out.println("   |   |   ");
        }
    }

    public int getState(){
        return updateState();
    }

    public int updateState(){
        int state = checkRow(0) + checkRow(1) + checkRow(2) + checkCol(0) + checkCol(1) + checkCol(2) + checkDiagonals();
        if (state != 0) {
            this.state = state;
        }
        else {
            this.state = checkDraw();
        }
        return this.state;
    }

    public int checkCol(int col){
        if(this.blocks[0][col].getState() != 0 && this.blocks[0][col].getState() == this.blocks[1][col].getState()
            && this.blocks[1][col].getState() == this.blocks[2][col].getState()){
                return this.blocks[0][col].getState();
            }
        return 0;
    }

    public int checkRow(int row){
        if(this.blocks[row][0].getState() != 0 && this.blocks[row][0].getState() == this.blocks[row][1].getState()
        && this.blocks[row][1].getState() == this.blocks[row][2].getState()){
            return this.blocks[row][0].getState();
        }
        return 0;
    }

    public int checkDiagonals(){
        if(this.blocks[0][0].getState() != 0 && this.blocks[0][0].getState() == this.blocks[1][1].getState()
        && this.blocks[1][1].getState() == this.blocks[2][2].getState()){
            return this.blocks[0][0].getState();
        }
        if(this.blocks[0][2].getState() != 0 && this.blocks[0][2].getState() == this.blocks[1][1].getState()
        && this.blocks[1][1].getState() == this.blocks[2][0].getState()){
            return this.blocks[0][2].getState();
        }
        return 0;
    }

    public int checkDraw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(this.blocks[i][j].getState() == 0)
                    return 0;
            }
        }
        return 1;
    }

    public boolean makeMove(int i, int state){
        int rowPos, colPos;
        switch (i) {
            case 1:
                rowPos = 0;
                colPos = 0;
                break;
            case 2:
                rowPos = 0;
                colPos = 1;
                break;
            case 3:
                rowPos = 0;
                colPos = 2;
                break;
            case 4:
                rowPos = 1;
                colPos = 0;
                break;
            case 5:
                rowPos = 1;
                colPos = 1;
                break;
            case 6:
                rowPos = 1;
                colPos = 2;
                break;
            case 7:
                rowPos = 2;
                colPos = 0;
                break;
            case 8:
                rowPos = 2;
                colPos = 1;
                break;
            case 9:
                rowPos = 2;
                colPos = 2;
                break;
            default:
                return false;
        }
        if(this.blocks[rowPos][colPos].getState() == 0){
            this.blocks[rowPos][colPos].setState(state);
            return true;
        }
        return false;
    }

}
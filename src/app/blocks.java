package app;

public class blocks implements global{
    private int state;

    public blocks(){
        this.state = 0;
    }

    public void setState(int state){
        if(isValidState(state)){
            this.state = state;
        }
    }

    public boolean isValidState(int state){
        return (state == 2 || state == 3);
    }

    public int getState(){
        return this.state;
    }

    public void undoState(){
        this.state = 0;
    }

    public String toString(){
        if (this.state == 0){
            return " ";
        }
        else if (this.state == 2){
            return "O";
        }
        else{
            return "X";
        }
    }

}

package app;

/**
 * Class Block implments Global, sets the states of each block
 * @author Uygur Tepe 105006877
 */
public class blocks implements global{
    private int state;

    /** 
     * Default Constructor of class Blocks
     */
    public blocks(){
        this.state = 0;
    }
    
    /**
     * Setter method. first checks if state is valid,
     * then sets the current instance of state 
     * @param state
     */
    protected void setState(int state){
        if(isValidState(state)){
            this.state = state;
        }
    }
    
    /** 
     * Method to check if the change of state is valid
     * @param state
     * @return true if state us valid, else false
     */
    private boolean isValidState(int state){
        return (state == 2 || state == 3);
    }
    
    /** 
     * Getter method to get the current instance of state
     * @return this.state
     */
    public int getState(){
        return this.state;
    }

    /**
     * Method to undo the current state
     * Used for the Minimax AI class when checking best/worse cases
     * sets current state back to 0
     */
    public void undoState(){
        this.state = 0;
    }

    
    /** 
     * @Overide
     * toString method
     * @return the current instance of state
     */
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

public class Moves {

    private enum typesOfMove {
        standBy, moveForward, moveBackward, moveUp, moveDown, Landing, takeOff,
        toggleFocus, capturePic
    }

    //Fields
    private typesOfMove currentMove = typesOfMove.standBy; //default is standBy

    //Methods
    public void setCurrentMove(String pMove) {
        this.currentMove = typesOfMove.valueOf(pMove);
    }
    public String getCurrentMove() { return this.currentMove.name(); }

}



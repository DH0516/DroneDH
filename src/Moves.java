public class Moves {

    private enum typesOfMove {
        standBy, moveForward, moveBackward, moveUp, moveDown, Landing, takeOff,
        focusObject, capturePic
    }

    private typesOfMove currentMove;

    public Moves() {
        currentMove = typesOfMove.standBy;
    }

    public void setCurrentMove(String pMove) {
        this.currentMove = typesOfMove.valueOf(pMove);
    }

    public String getCurrentMove() {
        return this.currentMove.name();
    }

}



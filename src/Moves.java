public class Moves {

    public enum typesOfMove {
        standBy, moveForward, moveBackward, moveUp, moveDown, Landing, takeOff,
        focusObject, capturePic
    }

    private typesOfMove currentMove;

    public Moves() {
        currentMove = typesOfMove.standBy;
    }

    public void setCurrentMove(typesOfMove pMove) {
        this.currentMove = pMove;
    }

    public typesOfMove getCurrentMove() {
        return this.currentMove;
    }

}



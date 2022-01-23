import java.util.ArrayList;

public class Control {
    private ArrayList<Moves> droneMoves; //Moves == standBy
    private Drone currentDrone; //Drone == Sitting
    private ArrayList<Photo> dronePhotos; //Photo == "untitled.raw"

    public Control(){
        System.out.println("Add moves, set photo modes. etc");
    }

    public void addOneMove(Moves pMove){
        droneMoves.add(pMove);
        System.out.println("Added " + pMove.getCurrentMove());
    }

    private void setPhoto(){
        
    }

    public void runAllMoves() {
        // check first move is taking off and last move is landing
        if (droneMoves.get(0).getCurrentMove() != Moves.typesOfMove.takeOff){
            System.out.println("Take Off command missing. Adding...");
            //add taking off?
        }
        for (Moves currentMove: droneMoves) {
            currentDrone.runMove(currentMove);
        }
    }
}

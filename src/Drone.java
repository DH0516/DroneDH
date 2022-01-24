import java.util.Objects;

public class Drone {

    private enum Drone_State {
        Focused,
        Moving,
        Sitting
    }

    private Drone_State currentState;
    private int Drone_Distance;
    private int Drone_Height;

    public Drone() { //Constructor
        currentState = Drone_State.Sitting;
        Drone_Distance = 0;
        Drone_Height = 0;

    }



    private void setCurrentState(Drone_State pState) {
        currentState = pState;
    }
    //cannot change current state of Drone

    public Drone_State getCurrentState() {
        return this.currentState;
    }


    public int getDrone_Distance(){ ////Debugging Purpose
        return this.Drone_Distance;
    }

    public int getDrone_Height(){////Debugging Purpose
        return this.Drone_Height;
    }

    public void printDrone_Position(){////Debugging Purpose
        System.out.println("Pos: " + this.Drone_Distance + ":" + this.Drone_Height);
    }

    public void setDrone_Height(int pHeight){
        this.Drone_Height = pHeight;
    }////Debugging Purpose

    public void setDrone_Distance(int pDistance){
        this.Drone_Distance = pDistance;
    }////Debugging Purpose


    //standBy, moveForward, moveBack, moveUp, moveDown, Land, takeOff, focusObject, capturePic
    public void runMove (Moves pMove) {
        try {
            //System.out.println("Current State is: " + getCurrentState());
            if (this.currentState == Drone_State.Moving) {
                switch (pMove.getCurrentMove()) {
                    case "standBy" -> //do nothing
                            System.out.println("runMove - standBy");
                    case "moveForward" -> {
                        System.out.println("runMove - moveForward");
                        this.Drone_Distance++;
                    }
                    case "moveBackward" -> {
                        System.out.println("runMove - moveBackward");
                        this.Drone_Distance--;
                    }
                    case "moveUp" -> {
                        System.out.println("runMove - moveUp");
                        this.Drone_Height++;
                    }
                    case "moveDown" -> {
                        System.out.println("runMove - moveDown");
                        this.Drone_Height--;
                    }
                    case "Landing" -> {
                        System.out.println("runMove - Landing. Drone_State is now Sitting");
                        this.Drone_Height = 0;
                        //notice how distance does not change from 'Land'
                        setCurrentState(Drone_State.Sitting);
                    }
                    case "focusObject" -> {
                        setCurrentState(Drone_State.Focused);
                        System.out.println("runMove - Focus on Object. Drone_State: Focused");
                    }
                    default -> {
                        try {
                            System.out.println(pMove.getCurrentMove());
                        }
                        catch (Exception e){
                            System.out.println("Invalid Move input: Drone.java");
                        }
                        System.out.println("Drone_State == Moving. Try a different Move");
                    }
                }
                printDrone_Position(); //Optional
            } else if (this.currentState == Drone_State.Sitting) {
                if (Objects.equals(pMove.getCurrentMove(), "takeOff")) {
                    System.out.println("First move is takeOff. Great!");
                    setDrone_Height(1);
                    setCurrentState(Drone_State.Moving);
                    System.out.println("Taking off... Drone is now Moving");
                    printDrone_Position();
                } else {
                    System.out.println("Drone_State == Sitting. Will take off first");
                    setDrone_Height(1);
                    setCurrentState(Drone_State.Moving);
                    System.out.println("Taking off... Drone is now Moving");
                    printDrone_Position();
                    runMove(pMove); //trying again. Intentionally recursive
                }
            } else if (this.currentState == Drone_State.Focused) {
                System.out.println("Photo Capture Command");
                if (Objects.equals(pMove.getCurrentMove(), "capturePic")) {
                    // capture pic goes here
                    Photo capture = new Photo();
                    capture.capture();
                    System.out.println("Capture successful");
                } else {
                    setCurrentState(Drone_State.Moving);
                    System.out.println("Drone_State is not Focused anymore");
                    runMove(pMove);
                }
            } else {
                System.out.println("Drone_State is invalid: Drone.java");
            }
        }
        catch (Exception e){
            System.out.println("Invalid Move: Drone.java");
        }
    }

    //private void


}

/*
Move
        - typeOfMove(enums MoveForward, backwards, landing,takeOff, etc.)
        - how much to move by (int field)
        - string photoname, fileformat (enum for all four types)

        getMoveType(returns typeOfMove)

Drone
        FIELDS
- height
        - distance
        - current_state = enum fosued/moving/sitting

        METHODS
        - runMove(Move pMove)
            -> check what type of move it is
            -> ex: if move == moveforward: distance++
                        move == moveup: height++
                    move == taking picture: first check if current_state == focused

Control
        intialize with list of moves and drone to control
        method to run all moves

        optional: add move to list of moves, remove move, etc.


RunDrone:
client builds list of moves to run
initializes all moves, drone object, control object
-> after they run all moves: controller.runMoves()

 */
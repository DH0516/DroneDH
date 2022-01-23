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



    public void setCurrentState(Drone_State pState) {
        currentState = pState;
    }

    public Drone_State getCurrentState() {
        return this.currentState;
    }

    public boolean photoReady() { return this.currentState == Drone_State.Focused; }


    public int getDrone_Distance(){
        return this.Drone_Distance;
    }

    public int getDrone_Height(){
        return this.Drone_Height;
    }

    public void printDrone_Position(){
        System.out.println(this.Drone_Distance);
        System.out.println(this.Drone_Height);
    }

    public void setDrone_Height(int pHeight){
        this.Drone_Height = pHeight;
    }

    public void setDrone_Distance(int pDistance){
        this.Drone_Distance = pDistance;
    }



    //standBy, moveForward, moveBack, moveUp, moveDown, Land, takeOff, focusObject, capturePic
    public void runMove (Moves pMove) {
        try {
            System.out.println("Current State is: " + getCurrentState());
            if (this.currentState == Drone_State.Moving) {
                switch (pMove.getCurrentMove()) {
                    case moveForward -> {
                        System.out.println("runMove - moveForward");
                        this.Drone_Distance++;
                    }
                    case moveBackward -> {
                        System.out.println("runMove - moveBackward");
                        this.Drone_Distance--;
                    }
                    case moveUp -> {
                        System.out.println("runMove - moveUp");
                        this.Drone_Height++;
                    }
                    case moveDown -> {
                        System.out.println("runMove - moveDown");
                        this.Drone_Height--;
                    }
                    case Landing -> {
                        System.out.println("runMove - Landing. Drone_State is now Sitting");
                        this.Drone_Height = 0;
                        //notice how distance does not change from 'Land'
                        this.currentState = Drone_State.Sitting;
                    }
                    case focusObject -> {
                        System.out.println("runMove - Focus on Object. Ready to take a photo now");
                        this.currentState = Drone_State.Focused;
                    }
                    default -> {
                        try {
                            System.out.println(pMove.getCurrentMove());
                        }
                        catch (Exception e){
                            System.out.println("Invalid Move input");
                        }
                        System.out.println("Drone_State == Moving. Try a different Move");
                    }
                }
                System.out.println("Drone currently at this position:");
                printDrone_Position(); //Optional
            } else if (this.currentState == Drone_State.Sitting) {
                if (pMove.getCurrentMove() == Moves.typesOfMove.takeOff) {
                    setCurrentState(Drone_State.Moving);
                } else {
                    System.out.println("Drone_State == Sitting. First need to takeOff");
                }
            } else if (this.currentState == Drone_State.Focused) {
                if (pMove.getCurrentMove() == Moves.typesOfMove.capturePic) {
                    // capture pic goes here
                    Photo capture = new Photo();
                    capture.capture();
                } else {
                    this.currentState = Drone_State.Moving;
                    System.out.println("Drone_State is not Focused anymore");
                }
            } else {
                System.out.println("Drone_State is invalid");
            }

        }
        catch (Exception e){
            System.out.println("Invalid Move");
        }
    }

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
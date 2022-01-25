public class Drone {

    private enum Drone_State {
        Focused,Moving,Sitting
    }
    //Fields
    private Drone_State currentState;
    private int Drone_Distance;
    private int Drone_Height;
    private String currentPhotoFileName;
    private String currentPhotoFormat;
    private Photo savedPhoto;
    private int counter = 0; //Drone internal counter of how many moves run. Check consistency with Control.MovesList


    public Drone() { //Constructor
        currentState = Drone_State.Sitting;
        Drone_Distance = 0;
        Drone_Height = 0;
    }

    //Methods
    public void setCurrentState(String pState) { this.currentState = Drone_State.valueOf(pState); }

    public String getCurrentState() {
        return this.currentState.name();
    }

    public int getDrone_Distance(){//Debug + Future implementation
        return this.Drone_Distance;
    }
    public int getDrone_Height(){//Debug + Future implementation
        return this.Drone_Height;
    }
    public void setDrone_Height(int pHeight){
        this.Drone_Height = pHeight;
    } //safe landing check
    public void setDrone_Distance(int pDistance){ this.Drone_Distance = pDistance; } //Future implementation for 'teleport'
    public void printDrone_Position(){
        System.out.println("Pos (D:H) : " + this.getDrone_Distance() + ":" + getDrone_Height() + " - " + getCurrentState());
    }//Debug Helper

    public String getPhotoFileName(){
        return this.currentPhotoFileName;
    }
    public void setPhotoFileName(String fileName){
        this.currentPhotoFileName = fileName;
    }
    public String getPhotoFormat(){
        return this.currentPhotoFormat;
    }
    public void setPhotoFormat(String Format){
        this.currentPhotoFormat = Format;
    }
    public Photo getSavedPhoto(){
        return this.savedPhoto;
    } //future: could become a list

    //standBy, moveForward, moveBackwards, moveUp, moveDown, Landing, takeOff, toggleFocus, capturePic
    public void runMove (Moves pMove) {
        try {
            //System.out.println("Current State is: " + getCurrentState());
            System.out.println("#" + counter + " ");
            counter ++;
            String input = pMove.getCurrentMove();
            switch (input) {
                case "standBy" -> { //do nothing
                    System.out.println("Success");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                case "moveForward" -> {
                    this.setCurrentState("Moving");
                    this.Drone_Distance++;
                    System.out.println("Success");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                case "moveBackward" -> {
                    this.setCurrentState("Moving");
                    this.Drone_Distance--;
                    System.out.println("Success");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                case "moveUp" -> {
                    this.setCurrentState("Moving");
                    this.Drone_Height++;
                    System.out.println("Success");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                case "moveDown" -> {
                    this.setCurrentState("Moving");
                    this.Drone_Height--;
                    System.out.println("Success");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                case "Landing" -> {
                    if (this.getDrone_Height() == 0) { //can't land when at 0 height
                        //notice how distance does not change from 'Land'
                        System.out.println("Landing: Drone has already landed - Do nothing");
                    }
                    else{
                        this.setDrone_Height(0);
                        System.out.println("Success");
                    }
                    this.setCurrentState("Sitting");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                case "toggleFocus" -> {
                    if (!getCurrentState().equals("Focused")) { //Moving --> Focused
                        this.setCurrentState("Focused");
                        System.out.println("Success");
                        System.out.println("runMove: " + input + " ON. - Drone_State: "  + getCurrentState());
                    }
                    else if (getCurrentState().equals("Focused")) { //Focused --> Moving
                        this.setCurrentState("Moving");
                        System.out.println("Success");
                        System.out.println("runMove: " + input + " OFF. - Drone_State: "  + getCurrentState());
                    }
                }
                case "capturePic" -> {
                    System.out.println("Capturing Photo...");
                    System.out.print("runMove: " + input);
                    this.capturePic();
                }
                case "takeOff" -> {
                    if (this.getCurrentState().equals("Sitting")) { //only take off when Sitting
                        System.out.println("Success");
                        this.setDrone_Height(1);
                    }
                    else{
                        System.out.println("takeOff: Drone is already in operation - Do nothing");
                    }
                    this.setCurrentState("Moving");
                    System.out.println("runMove: " + input + " - Drone_State: " + getCurrentState());
                }
                default -> System.out.println("Invalid move input: Drone.java");
            }
            printDrone_Position();
        }
        catch (Exception e){
            System.out.println("Invalid move input: Drone.java");
        }
    }

    private void capturePic(){ //Capture process
        System.out.println(" - Drone_State: " + getCurrentState());
        if (!getCurrentState().equals("Focused")){
            System.out.println("Drone is not in focus. Please turn on toggleFocus - Photo not taken");
            return; //do not proceed if !Focused
        }
        try { //Drone is Focused. Take picture
            if (getPhotoFileName() != null) { //only require name. modifiable format extension will be default 'raw'
                Photo capture = new Photo();
                capture.setFileName(getPhotoFileName());
                capture.setFormat(getPhotoFormat());
                capture.saveFile();
                this.savedPhoto = capture;
                System.out.println("Capture successful: " + getSavedPhoto().getSavedPic());
            } else {
                System.out.println("Need to set the file name! Cannot take photo");
            }
        }
        catch (Exception e){
            System.out.println("Invalid Photo Mode!");
        }
    }

}

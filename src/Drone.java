public class Drone {

    private enum Drone_State {
        Focused,
        Moving,
        Sitting
    }

    private Drone_State currentState;
    private int Drone_Distance;
    private int Drone_Height;
    private String currentPhotoFileName;
    private String currentPhotoFormat;
    private Photo savedPhoto;


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


    public int getDrone_Distance(){//Debug + Future implementation
        return this.Drone_Distance;
    }

    public int getDrone_Height(){//Debug + Future implementation
        return this.Drone_Height;
    }

    public void printDrone_Position(){//Debug Helper
        System.out.println("Pos (D:H) : " + this.Drone_Distance + ":" + this.Drone_Height + " - " + getCurrentState());
    }

    public void setDrone_Height(int pHeight){
        this.Drone_Height = pHeight;
    }

    public void setDrone_Distance(int pDistance){//Debug + Future implementation
        this.Drone_Distance = pDistance;
    }


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
    }

    //standBy, moveForward, moveBack, moveUp, moveDown, Land, takeOff, toggleFocus, capturePic
    public void runMove (Moves pMove) {
        try {
            //System.out.println("Current State is: " + getCurrentState());
            String input = pMove.getCurrentMove();
            switch (input) {
                case "standBy" -> //do nothing
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                case "moveForward" -> {
                    setCurrentState(Drone_State.Moving);
                    this.Drone_Distance++;
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                }
                case "moveBackward" -> {
                    setCurrentState(Drone_State.Moving);
                    this.Drone_Distance--;
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                }
                case "moveUp" -> {
                    setCurrentState(Drone_State.Moving);
                    this.Drone_Height++;
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                }
                case "moveDown" -> {
                    setCurrentState(Drone_State.Moving);
                    this.Drone_Height--;
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                }
                case "Landing" -> {
                    this.Drone_Height = 0;
                    //notice how distance does not change from 'Land'
                    setCurrentState(Drone_State.Sitting);
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                }
                case "toggleFocus" -> {
                    if (!getCurrentState().equals(Drone_State.Focused)) {
                        setCurrentState(Drone_State.Focused);
                        System.out.println("runMove: " + input + " ON. Drone_State: "  + getCurrentState());
                    }
                    else{
                        setCurrentState(Drone_State.Moving);
                        System.out.println("runMove: " + input + " OFF. Drone_State: "  + getCurrentState());
                    }
                }
                case "capturePic" -> {
                    System.out.print("runMove: " + input);
                    capturePic();
                }
                case "takeOff" -> {
                    setDrone_Height(1);
                    setCurrentState(Drone_State.Moving);
                    System.out.println("runMove: " + input + " Drone_State: " + getCurrentState());
                }
                default -> System.out.println("Invalid move input: Drone.java");
            }
            printDrone_Position();
        }
        catch (Exception e){
            System.out.println("Invalid move input: Drone.java");
        }
    }

    private void capturePic(){ //Capture process. 1: success 0: fail
        System.out.println(" Drone_State: " + getCurrentState());
        if (getCurrentState() != Drone_State.Focused){
            System.out.println("Drone is not in focus. Please turn on toggleFocus - Photo not taken");
            return;
        }
        try {
            if (getPhotoFileName() != null) { //only require name. extension will be default raw
                Photo capture = new Photo();
                capture.setFileName(getPhotoFileName());
                capture.setFormat(getPhotoFormat());
                capture.saveFile();
                this.savedPhoto = capture;
                System.out.println("Capture successful: " + getPhotoFileName() + "." + getPhotoFormat());
            } else {
                System.out.println("Need to set the file name! Cannot take photo");
            }
        }
        catch (Exception e){
            System.out.println("Invalid Photo Mode!");
        }
    }


}

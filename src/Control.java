import java.util.LinkedList;

public class Control {
    private final LinkedList<Moves> MovesList = new LinkedList<>(); //Moves == standBy
    private final Drone currentDrone = new Drone(); //Drone == Sitting


    public void printMovesList() {
        for (Moves pMove : MovesList){
            System.out.println(pMove.getCurrentMove());
        }
    }

    public void setPhotoName(String name){ //Setter
        try {
            System.out.println("File Name: " + name);
            this.currentDrone.setPhotoFileName(name);
        }
        catch (Exception e){
            System.out.println("Invalid file Name input. Will ignore: Control.java");
        }
    }

    public void setPhotoFormat(String format){ //Setter
        try {
            System.out.println("File Format: " + format);
            this.currentDrone.setPhotoFormat(format);
        }
        catch (Exception e){
            System.out.println("Invalid file format input. Will ignore: Control.java");
        }
    }


    public void getSavedPhotoFromDrone(){
        Photo savedPhoto = currentDrone.getSavedPhoto();
        System.out.println("Drone saved this photo: " + savedPhoto.getSavedPic());
    }


    public void add (String moveName){
        try {
            Moves pMove = new Moves();
            pMove.setCurrentMove(moveName);
            MovesList.add(pMove);
            System.out.print("Added: ");
            System.out.println(pMove.getCurrentMove());
        }
        catch (Exception e){
            System.out.println("Error: Could not add " + moveName);
        }
    }

    public void add (int orderPosition, String moveName){
        try {
            Moves pMove = new Moves();
            pMove.setCurrentMove(moveName);
            MovesList.add(orderPosition,pMove);
            System.out.print("Added: ");
            System.out.println(pMove.getCurrentMove());
        }
        catch (Exception e){
            System.out.println("Error: Could not add " + moveName);
        }
    }

    public void remove(){
        try{
            String result = MovesList.getLast().getCurrentMove();
            MovesList.removeLast();
            System.out.print("Removed: ");
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Error: Could not remove");
        }
    }

    public void runAll(){
        System.out.println("Starting runAll!");
        try{
            if (!MovesList.getFirst().getCurrentMove().equals("takeOff")){
                System.out.println("Must takeOff first - Adding takeOff");
                add(0,"takeOff");
            }
            if (!MovesList.getLast().getCurrentMove().equals("Landing")){
                System.out.println("Must Land at the end - Adding Landing");
                add("Landing");
            }
            System.out.println();
            for (Moves pMove : MovesList) {
                currentDrone.runMove(pMove);
            }
            System.out.println("Done performing all moves.");
            System.out.println();
            getSavedPhotoFromDrone();
            System.out.println("Done loading photo.");
            System.out.println();
            System.out.println("Print moves that ran:");
            printMovesList();
        }
        catch (Exception e){
            System.out.println("Drone not connected!");
        }
    }

}

/*
    public String setPhotoName(){ //if no Photo Name preset - Debugging
        try {
            Scanner name = new Scanner(System.in);
            System.out.println("fileName: ");
            return name.nextLine();
        }
        catch (Exception e){
            System.out.println("Invalid fileName input: Control.java");
            return ("untitled");
        }
    }

    public String setPhotoFormat(){ //if no Photo Format preset - Debugging
        try {
            Scanner format = new Scanner(System.in);
            System.out.println("Format: ");
            return format.nextLine();
        }
        catch (Exception e){
            System.out.println("Invalid file Format input: Control.java");
            return ("raw");
        }
    }

     */

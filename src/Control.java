import java.util.LinkedList;
//import java.util.Scanner; //used for debugging purposes only

public class Control {
    private LinkedList<Moves> MovesList = new LinkedList<>(); //Moves == standBy
    private Drone currentDrone = new Drone();; //Drone == Sitting
    private Photo savedPhoto = new Photo();
    //Photo list string deep-copied from Drone.java


    public Control(){

    }



    public String setPhotoName(String name){ //Setter
        try {
            System.out.println("File Name: " + name);
            this.currentDrone.setPhotoFileName(name);
            return name;
        }
        catch (Exception e){
            System.out.println("Invalid file Name input. Will ignore: Control.java");
            return ("untitled");
        }
    }

    public String setPhotoFormat(String format){ //Setter
        try {
            System.out.println("File Format: " + format);
            this.currentDrone.setPhotoFormat(format);
            return format;
        }
        catch (Exception e){
            System.out.println("Invalid file format input. Will ignore: Control.java");
            return ("raw");
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

    public void getSavedPhotoFromDrone(){
        savedPhoto = currentDrone.getSavedPhoto();
        System.out.println("Drone saved this photo: " + savedPhoto.getSavedPic());
    }


    public int add (String moveName){
        try {
            Moves pMove = new Moves();
            pMove.setCurrentMove(moveName);
            MovesList.add(pMove);
            System.out.print("Added: ");
            System.out.println(pMove.getCurrentMove());
            return 1;
        }
        catch (Exception e){
            System.out.println("Invalid Move input. Will not add: " + moveName);
            return 0;
        }
    }

    public int remove(){
        try{
            String result = MovesList.getLast().getCurrentMove();
            MovesList.removeLast();
            System.out.print("Removed: ");
            System.out.println(result);
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    public int runAll(){
        System.out.println("Starting Run!");
        try{
            for (Moves pMove : MovesList) {
                currentDrone.runMove(pMove);
            }
            System.out.println("Done performing all moves");
            getSavedPhotoFromDrone();
            System.out.println("Done loading photo");
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

}


/*

Control.runAll speaks only to Drone
 */
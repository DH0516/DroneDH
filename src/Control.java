import java.util.LinkedList;
import java.util.Scanner; //used for debugging purposes only

public class Control {
    private LinkedList<Moves> MovesList = new LinkedList<>(); //Moves == standBy
    private Drone currentDrone; //Drone == Sitting
    private LinkedList<Photo> PhotosList = new LinkedList<>(); //Photo == "untitled.raw"


    public Control(){

    }



    public String setPhotoName(String name){ //Setter
        try {
            System.out.println("fileName: " + name);
            return name;
        }
        catch (Exception e){
            System.out.println("Invalid fileName input: Control.java");
            return ("untitled");
        }
    }

    public String setPhotoFormat(String format){ //Setter
        try {
            System.out.println("File Format: " + format);
            return format;
        }
        catch (Exception e){
            System.out.println("Invalid file format input: Control.java");
            return ("raw");
        }
    }

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
            System.out.println("Invalid Input. Will not add: " + moveName);
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
            Drone Drone = new Drone();
            for (Moves pMove : MovesList) {
                Drone.runMove(pMove);
            }
            for (Photo pPhoto : PhotosList) {
                System.out.println("Photos List: " + pPhoto.getSavedPic());
            }
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

}

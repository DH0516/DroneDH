import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class Control {
    private LinkedList<Moves.typesOfMove> MovesList = new LinkedList<>(); //Moves == standBy
    private Drone currentDrone; //Drone == Sitting
    private LinkedList<Photo> dronePhotos; //Photo == "untitled.raw"


    public Control(){

    }

    public String setPhotoName(){ //if no Photo Name preset
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

    public String setPhotoFormat(){ //if no Photo Format preset
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

    public String getPhotoFormat(){ //if no Photo Format preset
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

    public int add (Moves.typesOfMove moveType){
        try {
            MovesList.add(moveType);
            System.out.println(moveType.name());
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    public int remove(){
        try{
            MovesList.removeLast();
            System.out.println(MovesList.getLast());
            return 1;
        }
        catch (Exception e){
            return 0;
        }
    }

    public int runAll(){
        try{

        }
        catch (Exception e){

        }
    }

}

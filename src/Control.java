import java.util.LinkedList;

public class Control {
    //Fields
    private final LinkedList<Moves> MovesList = new LinkedList<>(); //Moves == standBy
    private final Drone currentDrone = new Drone(); //Drone == Sitting

    //Methods
    public void printMovesList() {
        for (Moves pMove : MovesList){
            System.out.print(MovesList.indexOf(pMove) + " ");
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

    public void getSavedPhotoFromDrone(){ //getter - Accesses Drone
        try {
            String result = this.currentDrone.getSavedPhoto().getSavedPic();
            System.out.println("Drone saved this photo: " + result);
        }
        catch (Exception e){
            System.out.println("Drone did not save any photo");
        }
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
            System.out.println("Error: Could not add " + moveName + " at position: " + orderPosition);
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
            System.out.println("Error: Could not remove last item");
        }
    }

    public void remove(int orderPosition){
        try{
            String result = MovesList.get(orderPosition).getCurrentMove();
            MovesList.remove(orderPosition);
            System.out.print("Removed: ");
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Error: Could not remove the item at position: " + orderPosition);
        }
    }

    public void runAll(){ //Accesses Drone
        System.out.println("Starting runAll!");
        try{
            if (!MovesList.getFirst().getCurrentMove().equals("takeOff")){
                System.out.println("Auto-Add: Must takeOff first - Adding takeOff...");
                add(0,"takeOff");
            }
            System.out.println();
            for (Moves pMove : MovesList) {
                currentDrone.runMove(pMove);
            }
            if (currentDrone.getDrone_Height() != 0){
                System.out.println("Auto-Add: Must Land at the end - Adding Landing...");
                add("Landing");
                currentDrone.runMove(MovesList.getLast());
            }
            System.out.println("---Done performing all moves.---");
            System.out.println();
            getSavedPhotoFromDrone();
            System.out.println();
            System.out.println("Recorded moves from the LinkedList of Control:");
            printMovesList();
        }
        catch (Exception e){
            System.out.println("Error at Control - runAll! Drone connection lost.");
        }
    }

}

/* Extra code for future & debugging
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

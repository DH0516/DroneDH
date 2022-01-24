import java.util.Scanner;

public class RunDrone {

    public static void main(String[] args) {

        Control remote = new Control();
        int test = remote.add(Moves.typesOfMove.moveForward);
        System.out.println(test);
        /*
        //will cause auto add of take off
        Control.add(move down)
        Control.add(move back)
        Control.add(move forward)
        Control.add(move forward)
        Control.remove() //remove the previous
        Control.setPhotoName("test1");
        Control.add(capturePic);
        Control.add(focusOnObject);
        Control.add(capturePic);
        Control.add(capturePic);
        Control.add(move forward)
        Control.add(Landing);
        Control.runAll;
        */
    }
}

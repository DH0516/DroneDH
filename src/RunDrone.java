import java.util.Scanner;

public class RunDrone {

    public static void main(String[] args) {

        Control remote = new Control();
        int test = remote.add("moveForward");
        //will cause auto add of take off
        int test2 = remote.add("this doesn't work");
        System.out.println(test2);

        remote.setPhotoFormat("PNG");
        remote.setPhotoName("test1");
        remote.add("moveBackward");
        remote.add("moveUp");
        remote.add("moveDown");
        remote.add("moveDown");
        remote.add("moveDown");
        remote.add("moveDown");
        remote.remove(); //remove the previous
        remote.add("capturePic"); //Drone_State == Moving. Try a different Move
        remote.add("focusObject");
        remote.add("capturePic");
        remote.add("moveForward");
        remote.add("focusObject");
        remote.add("capturePic");
        remote.add("Landing");
        System.out.println("----------------------------");
        remote.runAll();

    }
}

public class RunDrone {
    /*
    1. Create a new Control
    2. Make a programmed move sequence (add, remove)
    standBy, moveForward, moveBackwards, moveUp, moveDown, Landing, takeOff, toggleFocus, capturePic
    3. Set Photo name and Photo format (setPhotoName, setPhotoFormat)
    4. 'runAll' to run the sequence
     */

    public static void main(String[] args) {

        Control remote = new Control();
        //will cause auto add of take off
        remote.remove(); //cannot remove from an empty list
        remote.add("this doesn't work");
        remote.add("capturePic");
        remote.setPhotoName("test1");
        remote.setPhotoFormat("jpg");
        remote.add("moveForward");
        remote.add("moveBackward");
        remote.add("moveUp");
        remote.add("moveDown");
        remote.add("capturePic"); //Drone_State == Moving. Try a different Move
        remote.add("toggleFocus");
        remote.add("capturePic");
        remote.add("moveForward"); //add automatic landing after
        System.out.println("----------------------------");
        remote.runAll();
        System.out.println();
        System.out.println();
        System.out.println("TEST2");
        Control remote2 = new Control();
        remote2.add("takeOff");
        remote2.add("takeOff");
        remote2.setPhotoName("test2");
        remote2.setPhotoFormat("fdas");
        remote2.remove(); //successful removal - takeOff
        remote2.add("Landing");
        remote2.add("moveForward");
        remote2.add("takeOff");
        remote2.add("takeOff");
        remote2.add("moveForward");
        remote2.add("Landing");
        remote2.add("Landing");
        remote2.add("toggleFocus");
        remote2.add("capturePic"); //test2.raw
        System.out.println("----------------------------");
        remote2.runAll();
        System.out.println();
        System.out.println();
        System.out.println("TEST3");
        Control remote3 = new Control();
        remote3.add("takeOff");
        remote3.setPhotoName("test3");
        remote3.add("Landing");
        remote3.add("toggleFocus");
        remote3.add("takeOff");
        remote3.add("takeOff");
        remote3.add("toggleFocus");
        remote3.add("capturePic"); //test3.raw
        remote3.add("moveForward");
        remote3.add("Landing");
        remote3.add("Landing");
        System.out.println("----------------------------");
        remote3.runAll();

    }
}

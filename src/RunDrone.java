public class RunDrone {

    public static void main(String[] args) {

        Control remote = new Control();
        //will cause auto add of take off
        remote.remove(); //remove the previous
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
        remote.add("moveForward");
        System.out.println("----------------------------");
        remote.runAll();
        System.out.println();
        System.out.println();
        System.out.println("TEST2");
        Control remote2 = new Control();
        remote2.add("takeOff");
        remote2.setPhotoName("test2");
        remote2.setPhotoFormat("fdas");
        remote2.add("Landing");
        remote2.add("moveForward");
        remote2.add("takeOff");
        remote2.add("takeOff");
        remote2.add("moveForward");
        remote2.add("Landing");
        remote2.add("Landing");
        remote2.add("toggleFocus");
        remote2.add("capturePic");
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

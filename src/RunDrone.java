public class RunDrone {

    public static void main(String[] args) {

        Control remote = new Control();
        //will cause auto add of take off
        remote.remove(); //remove the previous
        remote.add("this doesn't work");
        remote.add("capturePic");
        remote.setPhotoName("test1");
        remote.setPhotoFormat("jpg");

        remote.add("capturePic"); //Drone_State == Moving. Try a different Move
        remote.add("toggleFocus");
        remote.add("capturePic");

        remote.add("moveForward");
        System.out.println("----------------------------");
        remote.runAll();

    }
}

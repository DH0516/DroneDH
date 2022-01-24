public class Photo {

    private enum saveFormats {
        jpg, png, raw, pdf
    }

    private String fileName;
    private saveFormats Format;

    public Photo() {
        fileName = "untitled";
        Format = saveFormats.raw;
        //RAW is default
    }

    private String formatAsString(saveFormats pForm){
        return pForm.name();
    }

    private int renameFile(String newName){//1 success 0 fail
        try {
            this.fileName = newName;
            return 1;
        }
        catch (Exception e){
            System.out.println("Invalid input for fileName: Photo.java");
            return 0;
        }
    }

    private int setFormat(String formatName){ //1 success 0 fail
        try {
            String input = formatName.toLowerCase();
            switch (input) {
                case "jpg":
                    this.Format = saveFormats.jpg;
                    break;
                case "png":
                    this.Format = saveFormats.png;
                    break;
                case "raw":
                    this.Format = saveFormats.raw;
                    break;
                case "pdf":
                    this.Format = saveFormats.pdf;
                    break;
                default:
                    System.out.println("Format has to be one of : JPG, PNG, RAW, PDF. Default RAW: Photo.java");
                    return 0;
                }
            return 1;
        }
        catch (Exception e){
            System.out.println("Format has to be one of : JPG, PNG, RAW, PDF. Default RAW: Photo.java");
            return 0;
        }
    }

    private String makeFile(){
        String result = this.fileName + formatAsString(this.Format);
        System.out.println(result);
        return result;
    }

    public String capture(String newName, String formatName) {
        System.out.println("Capturing photo...");

        int nameTester = renameFile(newName);
        if (nameTester == 0) {
            this.fileName = "untitled";
            System.out.println("Invalid name. fileName default 'untitled': Photo.java");
        }
        System.out.println("Setting File Name to " + newName);

        int formatTester = setFormat(formatName);
        if (formatTester == 0) {
            this.Format = saveFormats.raw;
            System.out.println("Invalid name. Format default 'RAW': Photo.java");
        }
        System.out.println("Setting format to " + formatName);
        String result = this.makeFile();
        System.out.println("Captured: " + result);
        return result;
        //result goes to Control.java
    }

    public void capture(){
        Control control = new Control();
        capture(control.setPhotoName(), control.setPhotoFormat());
    }

}

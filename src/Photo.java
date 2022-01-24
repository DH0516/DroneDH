public class Photo {

    private enum saveFormats {
        jpg, png, raw, pdf
    }

    private String fileName;
    private saveFormats Format;
    private String savedPic;

    public Photo() {    }

    public String getSavedPic(){
        return this.savedPic;
    }

    private String formatAsString(saveFormats pForm){
        return pForm.name();
    }

    private String getFileName(){
        return this.fileName;
    }

    private int setFileName(String newName){//1 success 0 fail
        try {
            this.fileName = newName;
            return 1;
        }
        catch (Exception e){
            System.out.println("Invalid input for fileName: Photo.java");
            return 0;
        }
    }

    private String getFormatName(){
        return this.Format.name();
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
        String result = this.fileName + "." + formatAsString(this.Format);
        System.out.println(result);
        return result;
    }

    public void capture(String newName, String formatName) {
        System.out.println("Capturing start...");

        int nameTester = setFileName(newName);
        if (nameTester == 0) {
            this.fileName = "untitled";
            System.out.println("Invalid name. fileName default 'untitled': Photo.java");
        }
        System.out.println("Setting File Name to " + newName);

        int formatTester = setFormat(formatName);
        if (formatTester == 0) {
            this.Format = saveFormats.raw;
        }
        System.out.println("Setting format to " + this.Format);
        String result = this.makeFile();
        System.out.println("Captured: " + result);
        this.savedPic = result;
        //result goes to Control.java
    }

    public void capture(){
        if (getFileName() == null || getFormatName() == null) {
            Control control = new Control();
            capture(control.setPhotoName(), control.setPhotoFormat());
        }
        capture(getFileName(), getFormatName());
    }

}

public class Photo {

    private enum saveFormats {
        JPG, PNG, RAW, PDF
    }

    public String fileName;
    public saveFormats Format;

    public Photo() {
        fileName = "untitled";
        Format = saveFormats.RAW;
        //RAW is default
    }

    private String formatAsString(saveFormats pForm){
        return pForm.name();
    }

    public void renameFile(String newName){
        this.fileName = newName;
    }

    public void setFormat(String formatName){
        switch (formatName){
            case "JPG" ->{
                this.Format = saveFormats.JPG;
            }
            case "PNG" -> {
                this.Format = saveFormats.PNG;
            }
            case "RAW" -> {
                this.Format = saveFormats.RAW;
            }
            case "PDF" -> {
                this.Format = saveFormats.PDF;
            }
            default -> {
                System.out.println("Format has to be one of : JPG, PNG, RAW, PDF. Default RAW");
            }
        }
    }

    private String makeFile(){
        String result = this.fileName + formatAsString(this.Format);
        System.out.println(result);
        return result;
    }

    public String capture() {
        System.out.println("Capturing...");
        String result = this.makeFile();
        System.out.println("Captured: " + result);
        return result;
    }

}

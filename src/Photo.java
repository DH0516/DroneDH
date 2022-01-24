public class Photo {

    private enum saveFormats {
        jpg, png, raw, pdf
    }

    private String fileName;
    private saveFormats Format;
    private String savedPic;

    public Photo() {    }

    public String getFileName(){
        return this.fileName;
    }
    public saveFormats getFormatName(){ return this.Format;}

    public String getSavedPic(){
        return this.savedPic;
    }



    public void setFileName(String newName){
        try {
            this.fileName = newName;
        }
        catch (Exception e){
            System.out.println("Invalid input for fileName: Photo.java");
            this.fileName = "untitled";
        }
    }


    public void setFormat(String formatName){
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
                    this.Format = saveFormats.raw;
                }
        }
        catch (Exception e){
            System.out.println("Format has to be one of : JPG, PNG, RAW, PDF. Default RAW: Photo.java");
            this.Format = saveFormats.raw;
        }
    }

    public String saveFile(){
        String result = getFileName() + "." + getFormatName();
        this.savedPic = result;
        return result;
    }


}

/*
Photo only speaks to Drone
 */

package DFS;

// File class
class File {
    private String fileName;
    private double fileSize;
    private boolean isReplicated;

    //constructor
    public File(String fileName, double fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isReplicated = false;
    }
    
    //getters
    public String getFileName() {
        return fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public boolean getisReplicated() {
        return isReplicated;
    }

    //setters
    public void setFileReplicated(){
        isReplicated = true;
    }
}
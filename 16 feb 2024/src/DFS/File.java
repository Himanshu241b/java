package DFS;

// File class
class File {
    private String fileName;
    private double fileSize;
    private boolean isReplicated;

    public File(String fileName, double fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isReplicated = false;
    }

    public String getFileName() {
        return fileName;
    }

    public double getFileSize() {
        return fileSize;
    }

    public boolean isReplicated() {
        return isReplicated;
    }

    public void setFileReplicated(){
        isReplicated = true;
    }
}
package Feb_16;

public class File {
    private String fileName;
    private double fileSize; // in megabytes
    private boolean isReplicated;

    public File(String fileName, double fileSize, boolean isReplicated) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.isReplicated = isReplicated;
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
}

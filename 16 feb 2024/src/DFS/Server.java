package DFS;

//imports
import java.util.List;
import java.util.ArrayList;
// Server class
class Server {
    private int serverId;
    final private double serverSpace = 1000;
    private List<File> files;

    public Server(int serverId) {
        this.serverId = serverId;
        files = new ArrayList<>();

    }

    public boolean fileExists(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
    public List<File> getFiles(){
        return files;
    }
    public double getServerSpace(){
        return serverSpace;
    }
  

    public void uploadFile(File file) throws DFSException {
        if (fileExists(file.getFileName())) {
            throw new DFSException("File already exists on the server.");
        }
        double occupiedSpace =  0;
        for(File serverFile : files)
            occupiedSpace += serverFile.getFileSize();
        if((serverSpace - occupiedSpace) < file.getFileSize())
            throw new NotEnoughSpaceException("File cant be uploaded as server is out of space."); 
        
        files.add(file);
    }

    public File downloadFile(String fileName) throws DFSException {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return file;
            }
        }
        throw new DFSException("File not found on the server.");
    }

    public void replicateFile(File file, Server destinationServer) throws DFSException {
        
        destinationServer.uploadFile(file);
        file.setFileReplicated();
    }
}


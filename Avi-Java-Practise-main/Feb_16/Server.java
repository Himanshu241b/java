package Feb_16;
import java.util.*;
public class Server {
    private String serverId;
    private List<File> files;

    public Server(String serverId) {
        this.serverId = serverId;
        this.files = new ArrayList<>();
    }

    public String getServerId() {
        return serverId;
    }

    public boolean fileExists(String fileName) {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public void uploadFile(File file) throws InsufficientSpaceException {
        if (calculateFreeSpace() < file.getFileSize()) {
            throw new InsufficientSpaceException();
        }
        files.add(file);
    }

    public File downloadFile(String fileName) throws DFSException {
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                return file;
            }
        }
        throw new DFSException("File not found on server: " + fileName);
    }

    public void replicateFile(File file, Server destinationServer) throws DFSException {
        if (!destinationServer.getServerId().equals(this.serverId)) {
            throw new DFSException("Replication destination server is not valid.");
        }

        destinationServer.uploadFile(file);
    }

    public double calculateFreeSpace() {
        // Implement the logic to calculate free space on the server
        // For simplicity, assuming the server has unlimited space
        return Double.MAX_VALUE;
    }
}

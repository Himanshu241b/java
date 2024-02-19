package DFS;

//imports
import java.util.List;
import java.util.ArrayList;
// DFSSystem class
class DFSSystem {
    private List<Server> servers;

    //constructor
    public DFSSystem() {
        servers = new ArrayList<>();
    }
    //method to add server to list of servers
    public void addServer(Server server) {
        servers.add(server);
    }
    //methos to upload a file
    public void uploadFile(File file, Server server) throws DFSException {
        server.uploadFile(file);
    }
    //method to download a file
    public File downloadFile(String fileName, Server server) throws DFSException {
        return server.downloadFile(fileName);
    }
    //method to replicate a file
    public void replicateFile(File file, Server sourceServer, Server destinationServer) throws DFSException {
        sourceServer.replicateFile(file, destinationServer);
    }
    //calculates free space available in server
    public double calculateFreeSpace(Server server) {
        double totalSpace = server.getServerSpace(); // Example: total space available on a server
        double usedSpace = 0;
        for (File file : server.getFiles()) {
            usedSpace += file.getFileSize();
        }
        return totalSpace - usedSpace;
    }
}

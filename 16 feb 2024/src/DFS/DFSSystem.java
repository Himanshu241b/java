package DFS;

//imports
import java.util.List;
import java.util.ArrayList;
// DFSSystem class
class DFSSystem {
    private List<Server> servers;

    public DFSSystem() {
        servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void uploadFile(File file, Server server) throws DFSException {
        server.uploadFile(file);
    }

    public File downloadFile(String fileName, Server server) throws DFSException {
        return server.downloadFile(fileName);
    }

    public void replicateFile(File file, Server sourceServer, Server destinationServer) throws DFSException {
        sourceServer.replicateFile(file, destinationServer);
    }

    public double calculateFreeSpace(Server server) {
        double totalSpace = server.getServerSpace(); // Example: total space available on a server
        double usedSpace = 0;
        for (File file : server.getFiles()) {
            usedSpace += file.getFileSize();
        }
        return totalSpace - usedSpace;
    }
}

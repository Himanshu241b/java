package Feb_16;
import java.util.*;

public class DFSSystem {
    private List<Server> servers;

    public DFSSystem() {
        this.servers = new ArrayList<>();
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public void uploadFile(File file, Server server) throws DFSException {
        if (!servers.contains(server)) {
            throw new DFSException("Server does not exist in the DFS.");
        }

        if (server.fileExists(file.getFileName())) {
            throw new DFSException("File already exists on the server: " + file.getFileName());
        }

        server.uploadFile(file);
    }

    public File downloadFile(String fileName, Server server) throws DFSException {
        if (!servers.contains(server)) {
            throw new DFSException("Server does not exist in the DFS.");
        }

        return server.downloadFile(fileName);
    }

    public void replicateFile(File file, Server sourceServer, Server destinationServer) throws DFSException {
        if (!servers.contains(sourceServer) || !servers.contains(destinationServer)) {
            throw new DFSException("Source or destination server does not exist in the DFS.");
        }

        if (!sourceServer.fileExists(file.getFileName())) {
            throw new DFSException("File does not exist on the source server: " + file.getFileName());
        }

        sourceServer.replicateFile(file, destinationServer);
    }
}

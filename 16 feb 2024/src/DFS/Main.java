package DFS;

public class Main {
    public static void main(String[] args) {
        // Example usage of DFS classes
        Server server1 = new Server(1);
        Server server2 = new Server(2);
        DFSSystem dfsSystem = new DFSSystem();

        dfsSystem.addServer(server1);
        dfsSystem.addServer(server2);

        try {
            File file1 = new File("document1.txt", 10.5);
            dfsSystem.uploadFile(file1, server1);

            File downloadedFile = dfsSystem.downloadFile("document1.txt", server1);
            System.out.println("Downloaded file: " + downloadedFile.getFileName());

            dfsSystem.replicateFile(file1, server1, server2);
            System.out.println("File replicated successfully.");

            double freeSpace = dfsSystem.calculateFreeSpace(server1);
            System.out.println("Free space on server 1: " + freeSpace + " MB");
        } catch (DFSException e) {
            System.out.println("DFS Exception: " + e.getMessage());
        }
    }
}

package Feb_16;

public class Main {
    public static void main(String[] args) {
        DFSSystem dfsSystem = new DFSSystem();

        Server server1 = new Server("Server1");
        Server server2 = new Server("Server2");

        dfsSystem.addServer(server1);
        dfsSystem.addServer(server2);

        try {
            File file1 = new File("Document1.txt", 5.0, false);
            File file2 = new File("Document2.txt", 3.0, false);

            dfsSystem.uploadFile(file1, server1);
            dfsSystem.uploadFile(file2, server2);

            File downloadedFile = dfsSystem.downloadFile("Document1.txt", server1);
            System.out.println("Downloaded File: " + downloadedFile.getFileName());

            dfsSystem.replicateFile(file1, server1, server2);
        } catch (DFSException e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

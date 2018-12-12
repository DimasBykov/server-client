
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.serverExample();
    }


    public void serverExample() throws IOException {
        ExecutorService service = Executors.newCachedThreadPool();
        int serverPort = 8080;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Server socket created on " + serverPort);
	    Socket clientSocket;
        while (true) {
            clientSocket = serverSocket.accept();
            service.execute(new Connect(clientSocket));
        }
    }
}

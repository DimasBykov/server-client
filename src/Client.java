import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.socketExample();
    }


    public void socketExample() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        
        Scanner in = new Scanner(System.in);

        while (true) {
	        System.out.println(reader.readLine());
            writer.println(in.nextLine());
        }
    }
}

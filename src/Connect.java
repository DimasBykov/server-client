import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect implements Runnable{
   private Socket socket;

    public Connect(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        writer.println("Спасибо за ");

        while (true){
            String message = reader.readLine();
            System.out.println(message);
            writer.println("Спасибо за "+ message);
        }
        }
        catch (IOException e){
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

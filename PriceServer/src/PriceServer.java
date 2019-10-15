import java.net.*;

public class PriceServer {

    public static void main(String[] args) {
        int port = 1000; // need same port, client can talk to server.
        try {
            ServerSocket server = new ServerSocket(port); // don't need to specify host name
            Socket pipe = server.accept(); // "wait until a client talks to you via link

            int x = pipe.getInputStream().read();

            System.out.println(x);

            pipe.getOutputStream().write(x + 1);
            pipe.getOutputStream().flush();

        } catch (Exception e) {
            e.printStackTrace(); //prints the traceback
        }
    }

}

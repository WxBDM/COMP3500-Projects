import java.net.*;

public class MainClient {

    public static void main(String[] args) {
        int port = 1000;
        try {
            Socket link = new Socket("localhost", port); // local computer
            link.getOutputStream().write(1);
            link.getOutputStream().flush();

            int i = link.getInputStream().read();

            System.out.println(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

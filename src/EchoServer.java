import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private int listenPort;

    public void setListenPort(int listenPort){
        this.listenPort = listenPort;
    }

    public void run() throws Exception {
        ServerSocket socket = new ServerSocket(listenPort);

        System.out.println("Starting java echo server...");
        System.out.println("Java echo server started");
        Socket sck = socket.accept();
        System.out.println("Listen started in 127.0.0.1:"+listenPort);

        EchoClient client = new EchoClient();
        client.handleClient(sck);
    }
}

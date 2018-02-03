import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EchoClient {

    private static final int BUFFER_SIZE = 512;

    private String getNowTime(){
        Date d = new Date();
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String q1 = d1.format(d);

        return q1;
    }

    public void handleClient(Socket socket) throws Exception {
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        int messageSize;
        byte buffer[] = new byte[BUFFER_SIZE];

        while ((messageSize = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, messageSize);
            System.out.println(getNowTime()+":Echo server respond");
        }

        System.out.println("Closing echo server...");
        socket.close();
    }
}

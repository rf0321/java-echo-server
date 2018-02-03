public class Main {

    public static void main(String[] args) throws Exception {
        EchoServer server = new EchoServer();
        server.setListenPort(3000);
        server.run();
    }
}

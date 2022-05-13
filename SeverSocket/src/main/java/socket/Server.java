package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket socket = null;

    public Server(int port) throws IOException {


        ServerSocket serverSocket = new ServerSocket(25000);
        System.out.println("Server port connection established");
            try {
                socket = serverSocket.accept();
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());

                BufferedReader br = new BufferedReader(isr);
                BufferedWriter bw = new BufferedWriter(osw);


                while (true) {
                    String msgFromClient = br.readLine();
                    System.out.println("Client" + msgFromClient);
                    bw.write("msgReceived");
                    System.out.println("Sever" + osw);

                    bw.newLine();


                    if (msgFromClient.equalsIgnoreCase("Bye"))
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                socket.close();


            }
        }
    public static void main(String address, int port) throws IOException {
        Server server = new Server(25000);
    }

}


